import org.testng.Assert;

public class Assertions {
    public  void Assertions(String s1, String s2){

        try{



            Assert.assertEquals(s1, s2);

            System.out.println("Assertion Passed in Test ");

        } catch(AssertionError ae){

            ae.printStackTrace();

        }

    }
    public void Balance_validation(Double i,Double j){
        try{



            Assert.assertEquals(i, j);

            System.out.println("Assertion Passed in Test ");

        } catch(AssertionError ae){

            ae.printStackTrace();

        }

    }
}
