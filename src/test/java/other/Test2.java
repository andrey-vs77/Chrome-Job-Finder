package other;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Test2 {

    @Test
    public void test1() throws IOException {
        //in provider
        ArrayList<LinkedHashMap> map = new ObjectMapper().readValue(input, ArrayList.class);
        System.out.println(map.size());
        for (LinkedHashMap carClass:map){
            //in modelBase childs
            ArrayList<LinkedHashMap> cars= (ArrayList<LinkedHashMap>) carClass.get("prices");
            System.out.println(cars.size());
            for (LinkedHashMap car:cars){
                carClass=car;
                System.out.println(car.get("modification"));
                System.out.println(carClass.get("modification"));
                String intAttr= (String) car.get("doors");
                Integer i = intAttr!=null ? Integer.parseInt(intAttr) : null ;

                System.out.println(intAttr);
            }
        }
    }

    String input="[\n" +
            "  {\n" +
            "   \"class\": \"«К1»\",\n" +
            "   \"doors\": \"\",\n" +
            "   \"body\": \"внедорожник\",\n" +
            "   \"prices\": [\n" +
            "    {\n" +
            "     \"modification\": \"Ambition\",\n" +
            "     \"brand\": \"Skoda\",\n" +
            "     \"model_body\": \"Kodiaq\",\n" +
            "     \"engine\": \"1.4\",\n" +
            "     \"fuel\": \"Бензин\",\n" +
            "     \"power\": \"150\",\n" +
            "     \"transmission\": \"Механика\",\n" +
            "     \"post_url\": \"http://skoda-kodiaq.infocar.ua/mod_1.4-tsi-6mt-ambition-4x4-110_kodiaq_id4955.html\",\n" +
            "     \"post_id\": \"id4955\",\n" +
            "     \"post_date\": \"01.03.2017\",\n" +
            "     \"price_usd\": \"28.445\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"modification\": \"Style\",\n" +
            "     \"brand\": \"Skoda\",\n" +
            "     \"model_body\": \"Kodiaq\",\n" +
            "     \"engine\": \"1.4\",\n" +
            "     \"fuel\": \"Бензин\",\n" +
            "     \"power\": \"150\",\n" +
            "     \"transmission\": \"Механика\",\n" +
            "     \"post_url\": \"http://skoda-kodiaq.infocar.ua/mod_1.4-tsi-6mt-style-4x4-110_kodiaq_id4955.html\",\n" +
            "     \"post_id\": \"id4955\",\n" +
            "     \"post_date\": \"01.03.2017\",\n" +
            "     \"price_usd\": \"29.779\"\n" +
            "    }]}]";
}
