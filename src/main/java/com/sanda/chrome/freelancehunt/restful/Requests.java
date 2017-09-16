package com.sanda.chrome.freelancehunt.restful;

import com.sanda.chrome.freelancehunt.restful.objects.FeedElement;
import com.sanda.chrome.freelancehunt.restful.objects.Project;
import com.sanda.chrome.freelancehunt.restful.objects.Skill;
import com.sanda.chrome.freelancehunt.security.SecurityApi;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cdc89 on 01.11.2016.
 *
 * @link https://freelancehunt.com/my/api
 */
@Component
public class Requests {

  private final int TIMEOUT = 10000;
  RestTemplate restTemplate;
  SecurityApi securityApi;
  HttpClientBuilder httpClientBuilder;
  HttpComponentsClientHttpRequestFactory requestFactory;

  public Requests() {
    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
    SSLContext sslContext = null;
    try {
      sslContext = org.apache.http.ssl.SSLContexts.custom()
          .loadTrustMaterial(null, acceptingTrustStrategy)
          .build();
    } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
      e.printStackTrace();
    }
    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
    httpClientBuilder = HttpClientBuilder.create();
    CloseableHttpClient httpClient = httpClientBuilder.setSSLSocketFactory(csf).build();
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(csf)
//                .build();
    requestFactory =
        new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    requestFactory.setConnectionRequestTimeout(TIMEOUT);
    requestFactory.setConnectTimeout(TIMEOUT);
    requestFactory.setReadTimeout(TIMEOUT);
    restTemplate = new RestTemplate(requestFactory);
    securityApi = new SecurityApi();
  }

  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  public HttpComponentsClientHttpRequestFactory getRequestFactory() {
    return requestFactory;
  }

  public void signRequest(String url) {
    String sign = securityApi.sign(url + "GET" + "");
    requestFactory =
        (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
    BasicCredentialsProvider bcp = new BasicCredentialsProvider();
    bcp.setCredentials(new AuthScope(AuthScope.ANY),
        new UsernamePasswordCredentials(securityApi.getId(), sign));
    httpClientBuilder.setDefaultCredentialsProvider(bcp);
    CloseableHttpClient httpClient = httpClientBuilder.build();
    requestFactory.setHttpClient(httpClient);
  }

  public List<Project> getProjects(String url) {
    Project[] projectsArray = restTemplate.getForObject(url, Project[].class);
    List<Project> resultList =
        projectsArray != null
            ? Arrays.asList(restTemplate.getForObject(url, Project[].class))
            : new ArrayList<>();
    return resultList;
  }

  public List<Skill> getSkills(String url) {
    List<Skill> resultList = Arrays.asList(restTemplate.getForObject(url, Skill[].class));
    return resultList;
  }

  public void getFeed(String url) {
    ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
    List<FeedElement> resultList = Arrays
        .asList(restTemplate.getForObject(url, FeedElement[].class));
    HttpHeaders headers = response.getHeaders();
    Set<Map.Entry<String, List<String>>> set = headers.entrySet();
    for (Map.Entry<String, List<String>> entry : set) {
//            System.out.println(entry.getKey()+" - "+entry.getValue().size()+" - "+ entry.getValue().get(0));
    }
    for (FeedElement element : resultList) {
//            System.out.println(element.toString());
    }

  }

  /**
   * this method created only for example
   */
  private void signRequestByHand(String url) {
    /**
     * making headers by hand
     */
    String sign = securityApi.sign(url + "GET" + "");
    String plainCreds = securityApi.getLogin() + ":" + sign;//"willie:p@ssword";
    byte[] plainCredsBytes = plainCreds.getBytes();
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);

    HttpEntity<String> request = new HttpEntity<String>(headers);
    //  ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
    /**
     * end of making headers by hand
     */
  }
}
