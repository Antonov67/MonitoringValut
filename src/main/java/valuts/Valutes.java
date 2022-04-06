package valuts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Valutes {

    @SerializedName("Date")
    @Expose
    public String date;
    @SerializedName("PreviousDate")
    @Expose
    public String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    public String previousURL;
    @SerializedName("Timestamp")
    @Expose
    public String timestamp;
    @SerializedName("Valute")
    @Expose
    public Valute valute;

    @Override
    public String toString() {
        return "Valutes{" +
                "date='" + date + '\'' +
                ", previousDate='" + previousDate + '\'' +
                ", previousURL='" + previousURL + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", valute=" + valute +
                '}';
    }
}

class Valute {

    @SerializedName("USD")
    @Expose
    public Usd usd;
    @SerializedName("EUR")
    @Expose
    public Eur eur;

    @Override
    public String toString() {
        return "Valute{" +
                "usd=" + usd +
                ", eur=" + eur +
                '}';
    }
}

class Usd {

    @SerializedName("ID")
    @Expose
    public String id;
    @SerializedName("NumCode")
    @Expose
    public String numCode;
    @SerializedName("CharCode")
    @Expose
    public String charCode;
    @SerializedName("Nominal")
    @Expose
    public Integer nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Previous")
    @Expose
    public Double previous;

    @Override
    public String toString() {
        return "Usd{" +
                "id='" + id + '\'' +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", previous=" + previous +
                '}';
    }
}

class Eur {

    @SerializedName("ID")
    @Expose
    public String id;
    @SerializedName("NumCode")
    @Expose
    public String numCode;
    @SerializedName("CharCode")
    @Expose
    public String charCode;
    @SerializedName("Nominal")
    @Expose
    public Integer nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Previous")
    @Expose
    public Double previous;

    @Override
    public String toString() {
        return "Eur{" +
                "id='" + id + '\'' +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", previous=" + previous +
                '}';
    }
}