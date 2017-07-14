package home.starks;

import java.util.StringJoiner;

public class LineHolder {

	String accountName;
	String accountNumber;
	String subName;
	String rOR;
	String commissionedSalesRep;
	String currency;
	String subVersion;
	String startDate;
	String termStartDate;
	String termEndDate;
	String subStatus;
	String amendCode;
	String amendType;
	String amendDate;
	String rpcChargeType;
	String amendEffectiveDate;
	String amendDescript;
	String prodName;
	String rpcName;
	String rpID;
	String prodRPID;
	String prodRPCID;
	String rpcID;
	String rpcOriginalID;
	String prodRPCChargeModel;
	String Quantity;
	String isLastSegment;
	String billToCountry;
	String soldToCountry;
	String rpcStartDate;
	String rpcEndDate;
	String subUpdateDate;
	String billingPeriod;

	public void set(int point, String value){
		switch (point) {
		case 0: accountName = value;break;
		case 1: accountNumber = value;break;
		case 2: subName = value;break;
		case 3: rOR = value;break;
		case 4: commissionedSalesRep = value;break;
		case 5: currency = value;break;
		case 6: subVersion = value;break;
		case 7: startDate = value;break;
		case 8: termStartDate = value;break;
		case 9: termEndDate = value;break;
		case 10: subStatus = value;break;
		case 11: amendCode = value;break;
		case 12: amendType = value;break;
		case 13: amendDate = value;break;
		case 14: rpcChargeType = value;break;
		case 15: amendEffectiveDate = value;break;
		case 16: amendDescript = value;break;
		case 17: prodName = value;break;
		case 18: rpcName = value;break;
		case 19: rpID = value;break;
		case 20: prodRPID = value;break;
		case 21: prodRPCID = value;break;
		case 22: rpcID = value;break;
		case 23: rpcOriginalID = value;break;
		case 24: prodRPCChargeModel = value;break;
		case 25: Quantity = value;break;
		case 26: isLastSegment = value;break;
		case 27: billToCountry = value;break;
		case 28: soldToCountry = value;break;
		case 29: rpcStartDate = value;break;
		case 30: rpcEndDate = value;break;
		case 31: subUpdateDate = value;break;
		case 32: billingPeriod = value;break;
		}
	}
	
	public String get(int point){
		String results = null;
		switch (point) {
		case 0: results = accountName; break;
		case 1: results = accountNumber; break;
		case 2: results = subName; break;
		case 3: results = rOR; break;
		case 4: results = commissionedSalesRep; break;
		case 5: results = currency; break;
		case 6: results = subVersion; break;
		case 7: results = startDate; break;
		case 8: results = termStartDate; break;
		case 9: results = termEndDate; break;
		case 10: results = subStatus; break;
		case 11: results = amendCode; break;
		case 12: results = amendType; break;
		case 13: results = amendDate; break;
		case 14: results = rpcChargeType; break;
		case 15: results = amendEffectiveDate; break;
		case 16: results = amendDescript; break;
		case 17: results = prodName; break;
		case 18: results = rpcName; break;
		case 19: results = rpID; break;
		case 20: results = prodRPID; break;
		case 21: results = prodRPCID; break;
		case 22: results = rpcID; break;
		case 23: results = rpcOriginalID; break;
		case 24: results = prodRPCChargeModel; break;
		case 25: results = Quantity; break;
		case 26: results = isLastSegment; break;
		case 27: results = billToCountry; break;
		case 28: results = soldToCountry; break;
		case 29: results = rpcStartDate; break;
		case 30: results = rpcEndDate; break;
		case 31: results = subUpdateDate; break;
		case 32: results = billingPeriod; break;
		}
		return(results);
	}
	
	public String toString(){
		StringJoiner sj = new StringJoiner("\t");
		String lineSep = "\r\n";
		sj.add(accountName);
		sj.add(accountNumber);
		sj.add(subName);
		sj.add(rOR);
		sj.add(commissionedSalesRep);
		sj.add(currency);
		sj.add(subVersion);
		sj.add(startDate);
		sj.add(termStartDate);
		sj.add(termEndDate);
		sj.add(subStatus);
		sj.add(amendCode);
		sj.add(amendType);
		sj.add(amendDate);
		sj.add(rpcChargeType);
		sj.add(amendEffectiveDate);
		sj.add(amendDescript);
		sj.add(prodName);
		sj.add(rpcName);
		sj.add(rpID);
		sj.add(prodRPID);
		sj.add(prodRPCID);
		sj.add(rpcID);
		sj.add(rpcOriginalID);
		sj.add(prodRPCChargeModel);
		sj.add(Quantity);
		sj.add(isLastSegment);
		sj.add(billToCountry);
		sj.add(soldToCountry);
		sj.add(rpcStartDate);
		sj.add(rpcEndDate);
		sj.add(subUpdateDate);
		sj.add(billingPeriod);
		sj.add(lineSep);
		return sj.toString();
	}



}
