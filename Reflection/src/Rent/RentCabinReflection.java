package Rent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * RentCabinReflection - test RentCabin class.
 * @author DJS
 *
 */
public class RentCabinReflection {
	/**
	 * main method - use reflection to test RentCabin
	 * @param args - not used
	 */
	public static void main(String[] args) {
		// Obtain the class object since we know the name of the class
		Class rental=RentCabin.class;
		try {
			//get the absolute name of the class using .getName()
			String rentalClassPackage=rental.getName();
			System.out.println("Class Name is : "+rentalClassPackage);
			
			// get the simple name of the class (without package info) using getSimpleName()
			String rentalClassNoPackage=rental.getSimpleName();
			System.out.println("Class Name without package is : "+rentalClassNoPackage);
			
			// get the package name of the class using getPackage()
			String rentalPackage=rental.getPackageName();
			System.out.println("Package Name is : "+rentalPackage);
			
			// get all the constructors of the class using getConstructor()
			Constructor[] constructors=rental.getConstructors();
			System.out.println("Constructors are : "+Arrays.toString(constructors));
			
			// get constructor with specific argument using getConstructor(Integer.TYPE)
			Constructor constructor=rental.getConstructor(Integer.TYPE);
			System.out.println("Parameterised Constructors are : "+constructor);
			
			// initialize an object of the myCabin class by passing in 2001 square-feet of area.
			RentCabin myCabin=(RentCabin) constructor.newInstance(2001);
			// get all methods declared in the class using getDeclaredMethods() - this excludes inherited methods
			Method[] declaredMethods=rental.getDeclaredMethods();
			System.out.println("Declared Methods are : "+Arrays.toString(declaredMethods));
			for(Method dmethod:declaredMethods) {
				System.out.println("method = "+dmethod.getName());
			}
			
			// get method with specific name "computeRentalCost" and parameters using getMethod
			Method oneMethod=rental.getMethod("computeRentalCost", new Class[] {Integer.TYPE});
			System.out.println("Method is : "+oneMethod);
			
			// call computeRentalCost method with parameter int numDays
			oneMethod.invoke(myCabin, 2);

			// gets all the public member fields of the class RentAuto using getFields()
			Field publicField=RentCabin.class.getDeclaredField("price");
			int fieldValue=(int)publicField.get(myCabin);
			System.out.println("The cost of your rental cabin is "+fieldValue+" USD");
			
			// get all the parameters of computeRentalCost
			Class[] parameterTypes=oneMethod.getParameterTypes();
			System.out.println("Parameter types of computeRentalCost() are : "+Arrays.toString(parameterTypes));

			// get the return type of computeRentalCost
			Class returnType=oneMethod.getReturnType();
			System.out.println("Return type is : "+returnType);
			
			Field[] field=RentCabin.class.getFields();
			//Print the public fields
			System.out.println("Public Fields are : ");
			//Please do note that we have made this for loop in order to display all the public data members we might have declared in RentCabin.java
			//Hence, this is the more generalized way of doing it.
			//Do note that we have done the other way around in the above code where we have printed 600 USD as rent.
			//Hence, this is used to display that we even know to display multiple public fields.
			//As, singular one is displayed above as well.
			for(Field oneField:field) {
				// get public field name
				Field fields=RentCabin.class.getField(oneField.getName());
				String fieldName=fields.getName();
				
				// get public field type
				System.out.println("Fieldname is : "+fieldName);
				Object fieldType=oneField.getType();
				System.out.println("Type of field "+fieldName+" is : "+fieldType);
				
				// get public field value
				Object value=oneField.get(myCabin);
				System.out.println("Value of field "+fieldName+" is : "+value);
			}
			
			// Access private member fields of the class using getDeclaredField() to return the private field "type"
			Field privateField=RentCabin.class.getDeclaredField("type");
			// use setAccessiblle to set private field instance accessible - for reflection use only, not normal code
			String name=privateField.getName();
			System.out.println("One private Fieldname is : "+name);
			
			// use setAccessiblle to set private field instance accessible - for reflection use only, not normal code
			privateField.setAccessible(true);

			// get the value of this private field
			Object value=privateField.get(myCabin);
			System.out.println("fieldValue = "+value);
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
