import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      dataDriven dd=new dataDriven();
      ArrayList data=dd.getData("Add Profile");
      System.out.println(data.get(0));
      System.out.println(data.get(1));
      System.out.println(data.get(2));
      System.out.println(data.get(3));
      System.out.println(data.get(3));
// for selenium
      //driver.findElement(by.xpath("hdg")).sendkeys(data.get(1));
      
      System.out.println(data.get(0));
      System.out.println(data.get(1));
      System.out.println(data.get(2));

	}

}
