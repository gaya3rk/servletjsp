package myBeans;
public class LocaleBean
{
	double cost;
	double markup;
	double subtotal;
	double vat;
	double total;
	public void setCost(double cost){
		this.cost=cost;
		this.markup=((cost/100)*20);
		this.subtotal=((cost+markup));
		this.vat=((subtotal/100)*12.5);
		this.total=(subtotal+vat);
	}
	public double getCost(){
		return cost;
	}
	public String getCostPrice(){
		return doFormat(cost);
	}
	public String getMarkup(){
		return doFormat(markup);
	}
	public String getSubtotal(){
		return doFormat(subtotal);
	}
	public String getvat(){
		return doFormat(vat);
	}
	public String getTotal(){
		return doFormat(total);
	}
	private String doFormat(double sum){
		java.util.Locale loc=new java.util.Locale("en","GB");
		java.text.NumberFormat nf=java.text.NumberFormat.getCurrencyInstance(loc);
		return nf.format(sum);
	}
}