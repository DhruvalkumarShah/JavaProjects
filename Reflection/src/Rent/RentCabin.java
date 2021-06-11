package Rent;
/**
 * RentCabin - Determine cabin type and rent of the cabin per night. 
 * @author DJS
 * @version 1.0
 */
public class RentCabin {
	private int rate;
	public int price;
	private String type;
	/**
	 * Declares the constructor which sets the type and rate based on square-foot of the cabin.
	 * @param sqft
	 */
	public RentCabin(int sqft) {
		//If the value of sqft is less than 1000 than cabin-type is small and rate is $100 per night.
		if(sqft<1000) {
			type="small";
			rate=100;
		}
		//If the value of sqft is greater than or equal to 1000 and less than or equal to 2000 than cabin-type is mid-sized and rate is $200 per night.
		else if(sqft>=1000&&sqft<=2000) {
			type="mid-sized";
			rate=200;
		}
		//If the value of sqft is greater than 2000 than cabin-type is large and rate is $300 per night.
		else {
			type="large";
			rate=300;
		}
	}
	/**
	 * getRate - return rental rate per night for the cabin.
	 * @return rate
	 */
	public int getRate() {
		return rate;
	}
	/**
	 * getType - return the type of the cabin availed by the customer for rent.
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * setRate - Sets the rate to the rate passed as parameter.
	 * @param cabinRate
	 */
	public void setRate(int cabinRate) {
		cabinRate=rate;
	}
	/**
	 * setType - Sets the cabin type to the paramter passed.
	 * @param cabinType
	 */
	public void setType(String cabinType) {
		cabinType=type;
	}
	/**
	 * computeRentalCost - Computes the rent for the number of nights stayed in the cabin.
	 * @param numDays
	 */
	public void computeRentalCost(int numDays) {
		price=numDays*rate;
	}
}