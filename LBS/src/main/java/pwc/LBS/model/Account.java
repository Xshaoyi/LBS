package pwc.LBS.model;

public class Account {
	public String Id;
	public String name;
	public String sic_category__c;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSic_category__c() {
		return sic_category__c;
	}
	public void setSic_category__c(String sic_category__c) {
		this.sic_category__c = sic_category__c;
	}
}
