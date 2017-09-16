package other;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @Test
    public void test5(){
        for (char ch='a'; ch<='a';ch++){
            for (char ch1=' ';ch1<='z';ch1++){
                if (ch1 >= 'A' && ch1 <= 'Z') {
                    continue;
                }
                System.out.println(""+ch+"|"+ch1);
            }
        }
    }

    @Test
    public void test4(){
        String i="24.125";
        i=i.replaceAll("\\.","");
        System.out.println("i - "+i);
    }

    @Test
    public void test3(){
        Integer i=Integer.parseInt("12999");
        System.out.println(String.format("i- %d",i));
    }

    @Test
    public void test2(){
        Parent p1=new Child1();
        Parent p2=new Child2();
        if (p1 instanceof Child1){
            //(Child2)
            ((Child1) p1).child1 = "child1";
            System.out.println("p1 instanceof Child1");
            p1.print();
        }
        if (p1 instanceof Child2){
            System.out.println("p1 instanceof Child2");
        }
        if (p1 instanceof Parent){
            System.out.println("p1 instanceof Parent");
        }
    }

    @Test
    public void test1(){
        String attribute="Volkswagen Passat CC 60";
        attribute=attribute.toLowerCase();
        BrandModelModileDe brandModel1=new BrandModelModileDe();
        brandModel1.brand="Volkswagen";
        List<CarModel> models=new ArrayList();
        CarModel carModel=new CarModel();
        carModel.model="Eos";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Golf";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Passat";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Passat CC";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Phaeton";
        models.add(carModel);
        brandModel1.models=models;

        BrandModelModileDe brandModel2=new BrandModelModileDe();
        brandModel2.brand="Volkswagen1";
        models=new ArrayList();
        carModel=new CarModel();
        carModel.model="Eos";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Golf";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Passat";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Passat CC";
        models.add(carModel);
        carModel=new CarModel();
        carModel.model="Phaeton";
        models.add(carModel);
        brandModel2.models=models;

        List<BrandModelModileDe> list=new ArrayList<>();
        list.add(brandModel1);
        list.add(brandModel2);


        BrandModelModileDe brandModel3=parseBrand(attribute,list);
        if (brandModel3==null){

            System.out.println(String.format("brandModel3 null"));
            return;
        }
        parseModel(attribute,brandModel3);
    }

    private void parseModel(String attribute, BrandModelModileDe brandModel) {
        String model=null;
        for (CarModel carModel:brandModel.models){
            //System.out.println(carModel.model.toLowerCase());
            if (attribute.contains(carModel.model.toLowerCase())){

                if(model==null || model.length()<carModel.model.length()){
                    model=carModel.model;
                }
            }
        }
        if (model!=null){
            System.out.println(String.format("model - %s",model));
            //car.set("model",prepareString(model));
        }
    }

    private BrandModelModileDe parseBrand(String attribute,List<BrandModelModileDe> modileDeList){
        BrandModelModileDe brandModel=null;
        for (BrandModelModileDe b:modileDeList){
            String brand=b.brand.toLowerCase();
            //System.out.println(brand);
            if (attribute.contains(brand)){
                if (brandModel==null || brandModel.brand.length()<brand.length()){
                    brandModel=b;

                }
            }
        }
        if (brandModel!=null){
            System.out.println(String.format("brand - %s",brandModel.brand));
            ///car.set("brand", prepareString(brandModel.brand));
        }
        return brandModel;
    }
}
