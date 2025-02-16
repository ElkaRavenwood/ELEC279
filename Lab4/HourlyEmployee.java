import java.util.Date;

/**
 Class Invariant: All objects have a name string, hire date, nonnegative
 wage rate, and nonnegative number of hours worked. A name string of
 "No name" indicates no real name specified yet. A hire date of Jan 1, 1000
 indicates no real hire date specified yet.
*/
public class HourlyEmployee extends Employee
                            implements Cloneable, Comparable <HourlyEmployee>, PayAble
{
    private double wageRate;
    private double hours; //for the month

    public HourlyEmployee( )
    {
        super( );
        wageRate = 0;
        hours = 0;
    }

    /**
     Precondition: Neither theName nor theDate is null;
     theWageRate and theHours are nonnegative.
    */
    public HourlyEmployee(String theName, Date theDate,
                       double theWageRate, double theHours)
    {
         super(theName, theDate);
         if ((theWageRate >= 0) && (theHours >= 0))
         {
             wageRate = theWageRate;
             hours = theHours;
         }
         else
         {
             System.out.println(
                       "Fatal Error: creating an illegal hourly employee.");
             System.exit(0);
         }
    }

    public HourlyEmployee(HourlyEmployee originalObject)
    {
         super(originalObject);
         wageRate = originalObject.wageRate;
         hours = originalObject.hours;
    }

    public double getRate( )
    {
        return wageRate;
    }

    public double getHours( )
    {
        return hours;
    }

    /**
     Returns the pay for the month.
    */
    public double getPay( )
    {
        return wageRate*hours;
    }

    /**
     Precondition: hoursWorked is nonnegative.
    */
    public void setHours(double hoursWorked)
    {
         if (hoursWorked >= 0)
             hours = hoursWorked;
         else
         {
             System.out.println("Fatal Error: Negative hours worked.");
             System.exit(0);
         }
     }

    /**
     Precondition: newWageRate is nonnegative.
    */
    public void setRate(double newWageRate)
    {
         if (newWageRate >= 0)
             wageRate = newWageRate;
         else
         {
             System.out.println("Fatal Error: Negative wage rate.");
             System.exit(0);
         }
    }

    public String toString( )
    {
        return (getName( ) + " " + getHireDate( ).toString( )
                + "\n$" + wageRate + " per hour for " + hours + " hours");
    }

    public boolean equals(HourlyEmployee other)
    {
       return (getName( ).equals(other.getName( ))
                && getHireDate( ).equals(other.getHireDate( ))
                && wageRate == other.wageRate
                && hours == other.hours);
    }

    public Object clone( )
    {
        HourlyEmployee copy =
                   (HourlyEmployee)super.clone( );
        copy.setRate(wageRate);
        copy.setHours(hours);
        
        return copy;
    }

    /**
     * Implementation of Comparable interface
     * @param anotherWorker the worker to compare the items to
     * @return integer representing how the employees compare
     */
    public int compareTo(HourlyEmployee anotherWorker) {
        return this.getName().compareTo(anotherWorker.getName());
    }

    /**
     * Used in printPayment. Finds the amount to pay
     * @return the amount to pay
     */
    public double amountToPay() {
        return wageRate*hours;
    }

    /**
     * Prints out information on the payment.
     */
    public void printPayment() {
        System.out.println("Payment information for an hourly employee. Employee name: " + this.getName() + "; payment " + amountToPay() +".");
    }

}
