

public class Calculator {
	private double res=0;
		
	
	public double getRes() {
		return res;
	}


	public void setRes(int res) {
		this.res = res;
	}


	public void add (double num1,double num2){
		res = num1+num2;
	}
	public void sub(double num1,double num2) {
		res = num1-num2;
	}
	public void mult(double num1,double num2) {
		res = num1*num2;
	}
	public void div(double num1,double num2) {
		res = num1/num2;
	}
}