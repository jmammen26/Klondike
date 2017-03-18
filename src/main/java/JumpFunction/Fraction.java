package JumpFunction;

/**
 * Created by Jeevan on 3/18/17.
 */
public class Fraction implements MathExpression<Fraction> {
    public int numerator;
    public int denominator;
    public boolean isNotValid(int denominator){
        return denominator == 0 ;
    }
    @Override
    public Fraction add(Fraction other) {
        if(isNotValid(numerator) || isNotValid(other.denominator)){
            throw new InvalidFraction("Denominator cannot be zero");
        }
        return null;
    }

    @Override
    public Fraction subtract(Fraction other) {
        if(isNotValid(numerator) || isNotValid(other.denominator)){
            throw new InvalidFraction("Denominator cannot be zero");
        }
        return null;
    }

    public class InvalidFraction extends RuntimeException {

        public InvalidFraction(String error){
            super(error);
        }
    }
}
