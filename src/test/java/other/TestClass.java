package other;

import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cdc89 on 11.03.2017.
 */
public class TestClass {

    @Test
    public void test5(){
        int i=0;
int y=0;
int x=1;
if (i!=0 || y !=0 || x!=0){
    System.out.println("YES");
}
    }

    @Test
    public void test4(){
        int i=9;
        if (i<10){
            System.out.println("i<10");
        }
        else if (i<800 && i>=10){
            System.out.println("i<800 && i>=10");
        } else {
            System.out.println("else");
        }
        i=25;
        if (i<10){
            System.out.println("i<10");
        }
        else if (i<800 && i>=10){
            System.out.println("i<800 && i>=10");
        } else {
            System.out.println("else");
        }
        i=1600;
        if (i<10){
            System.out.println("i<10");
        }
        else if (i<800 && i>=10){
            System.out.println("i<800 && i>=10");
        } else {
            System.out.println("else");
        }
    }

    @Test
    public void tesst3() {
String s1="Honda Civic 4D 2008 + ГБО\\nПробег 83500 тыс км\\nПродам свой личный автомобиль в идеальном состоянии.\\nУстановлено дорогое ГБО, баллон 54л.\\nМаксимальная комплектация кроме кожи (климат контроль, подрулевые лепестки, мультируль, люк, подогрев сидений, подогрев зеркал, электропривод зеркал, CD чейнжер на 6 дисков, черный велюровый салон)\\nКоробка автомат\\nПодрулевые лепестки\\nНе крашена ни одна деталь 100%\\nТехнически всё в идеальном состоянии\\nНа 80 тыс было сделано полное ТО (Замена масла в коробке, в двигателе, замена тормозной жидкости, регулировка клапанов)\\nВсе ТО машина проходила у Легендарного Ромы из Хонда Мафии, реклама этому человеку не нужна.\\nИз допов:\\nТонировка\\nПередний и задний парктроник\\nПолностью обесшумлена\\nGSM сигнализация с Авто запуском (Возможно отслеживать местоположения автомобиля в режиме онлайн с полной историей за целый день)\\nНовая зимняя резина проехала 1500 км\\nЯ владелец по техпаспорту, продажа только со снятием с учёта.\\nМашиной будете очень довольный, машин в таком состоянии просто нет. Это машина для тех, кто хочет купить идеальную машину и не жить на СТО.\\nПлощадки и перекупщики не тратьте своё время, просьба не беспокоить.\\nПродажа не срочная, обмен не предлагать.\\nОбзор установки ГБО на моей машине https://www.youtube.com/watch?v=itOqTGt_HzM&t=5s\\nГотов к проверке на любом СТО.";
if (s1.toLowerCase().contains("ГБО".toLowerCase()) || s1.toLowerCase().contains("ГАЗ".toLowerCase()))
    System.out.println("газ/бензин");
        s1="Honda Civic 4D 2008 + \\nПробег 83500 тыс км\\nПродам свой личный автомобиль в идеальном состоянии.\\nУстановлено дорогое , баллон 54л.\\nМаксимальная комплектация кроме кожи (климат контроль, подрулевые лепестки, мультируль, люк, подогрев сидений, подогрев зеркал, электропривод зеркал, CD чейнжер на 6 дисков, черный велюровый салон)\\nКоробка автомат\\nПодрулевые лепестки\\nНе крашена ни одна деталь 100%\\nТехнически всё в идеальном состоянии\\nНа 80 тыс было сделано полное ТО (Замена масла в коробке, в двигателе, замена тормозной жидкости, регулировка клапанов)\\nВсе ТО машина проходила у Легендарного Ромы из Хонда Мафии, реклама этому человеку не нужна.\\nИз допов:\\nТонировка\\nПередний и задний парктроник\\nПолностью обесшумлена\\nGSM сигнализация с Авто запуском (Возможно отслеживать местоположения автомобиля в режиме онлайн с полной историей за целый день)\\nНовая зимняя резина проехала 1500 км\\nЯ владелец по техпаспорту, продажа только со снятием с учёта.\\nМашиной будете очень довольный, машин в таком состоянии просто нет. Это машина для тех, кто хочет купить идеальную машину и не жить на СТО.\\nПлощадки и перекупщики не тратьте своё время, просьба не беспокоить.\\nПродажа не срочная, обмен не предлагать.\\nОбзор установки ГАЗ на моей машине https://www.youtube.com/watch?v=itOqTGt_HzM&t=5s\\nГотов к проверке на любом СТО.";
        if (s1.toLowerCase().contains("ГБО".toLowerCase()) || s1.toLowerCase().contains("ГАЗ".toLowerCase()))
            System.out.println("газ/бензин");
        s1="Honda Civic 4D 2008 + ГБО\\nПробег 83500 тыс км\\nПродам свой личный автомобиль в идеальном состоянии.\\nУстановлено дорогое ГБО, баллон 54л.\\nМаксимальная комплектация кроме кожи (климат контроль, подрулевые лепестки, мультируль, люк, подогрев сидений, подогрев зеркал, электропривод зеркал, CD чейнжер на 6 дисков, черный велюровый салон)\\nКоробка автомат\\nПодрулевые лепестки\\nНе крашена ни одна деталь 100%\\nТехнически всё в идеальном состоянии\\nНа 80 тыс было сделано полное ТО (Замена масла в коробке, в двигателе, замена тормозной жидкости, регулировка клапанов)\\nВсе ТО машина проходила у Легендарного Ромы из Хонда Мафии, реклама этому человеку не нужна.\\nИз допов:\\nТонировка\\nПередний и задний парктроник\\nПолностью обесшумлена\\nGSM сигнализация с Авто запуском (Возможно отслеживать местоположения автомобиля в режиме онлайн с полной историей за целый день)\\nНовая зимняя резина проехала 1500 км\\nЯ владелец по техпаспорту, продажа только со снятием с учёта.\\nМашиной будете очень довольный, машин в таком состоянии просто нет. Это машина для тех, кто хочет купить идеальную машину и не жить на СТО.\\nПлощадки и перекупщики не тратьте своё время, просьба не беспокоить.\\nПродажа не срочная, обмен не предлагать.\\nОбзор установки ГАЗ на моей машине https://www.youtube.com/watch?v=itOqTGt_HzM&t=5s\\nГотов к проверке на любом СТО.";
        if (s1.toLowerCase().contains("ГБО".toLowerCase()) || s1.toLowerCase().contains("ГАЗ".toLowerCase()))
            System.out.println("газ/бензин");
    }

    @Ignore
    @Test
    public void test2() throws ParseException {
        Date parseDate = new SimpleDateFormat("ddMMyyyy").parse("06032017");
        System.out.println(String.format("parseDate - %s", parseDate));
        Date currentDate = new Date();
        int dateDiff = Math.toIntExact((currentDate.getTime() - parseDate.getTime()) / (24 * 60 * 60 * 1000));
        System.out.println(dateDiff);
    }

    @Ignore
    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int currentYear = cal.get(Calendar.YEAR);
        System.out.println(currentYear);
        String condition = (2015 >= (2017 - 2) && 90 <= 100) ? "new" : "used";
        System.out.println(condition);
        condition = (2014 >= (2017 - 2) && 90 <= 100) ? "new" : "used";
        System.out.println(condition);
        condition = (2014 >= (2017 - 2) && 80 <= 100) ? "new" : "used";
        System.out.println(condition);
        String dateStart = "01/14/2012 09:29:58";
        String dateStop = "01/15/2012 10:31:48";
        testDays(dateStart, dateStop);
        dateStart = "01/14/2012 09:29:58";
        dateStop = "01/14/2012 8:31:48";
        testDays(dateStart, dateStop);
        dateStart = "01/14/2012 09:29:58";
        dateStop = "01/14/2012 10:31:48";
        testDays(dateStart, dateStop);
        Double d = Double.parseDouble("123,456".replace(',', '.'));
        System.out.println(d);
    }

    private void testDays(String dateStart, String dateStop) {
        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.println(Math.toIntExact(diffDays) + " days, ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
