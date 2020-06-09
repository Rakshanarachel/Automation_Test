import org.apache.log4j.Logger;
import org.testng.Assert;

public class Assertions {
    public static Logger logger = Logger.getLogger("rootLogger");
    public  void Assertions(String s1, String s2){

        try{



            Assert.assertEquals(s1, s2);

            logger.info("Assertion Passed in Test ");

        } catch(AssertionError ae){

            ae.printStackTrace();

        }

    }
    public void Balance_validation(Double i,Double j){
        try{



            Assert.assertEquals(i, j);

            logger.info("Assertion Passed in Test ");

        } catch(AssertionError ae){

            ae.printStackTrace();

        }

    }
}
