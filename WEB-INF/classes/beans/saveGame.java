//Erstellt von Kahraman Ali

package beans;

import java.io.Serializable;
import java.util.Date;

public class saveGame implements Serializable {

	private long spiellaenge;
	private String schwierigkeit;
	private String spieltyp;
	private int userid;
	private int gameid;
	private String userName;
	private int playedGames;
	private int rightUserSolutions;
	private int averageGameTime;

	private String aufgabe_01;
	private int loesung_01;
	private String aufgabe_02;
	private int loesung_02;
	private String aufgabe_03;
	private int loesung_03;
	private String aufgabe_04;
	private int loesung_04;
	private String aufgabe_05;
	private int loesung_05;
	private String aufgabe_06;
	private int loesung_06;
	private String aufgabe_07;
	private int loesung_07;
	private String aufgabe_08;
	private int loesung_08;
	private String aufgabe_09;
	private int loesung_09;
	private String aufgabe_10;
	private int loesung_10;
	private int gesamtRichtigeErgebniss;

	public Integer getGesamtRichtigeErgebniss() {
		return gesamtRichtigeErgebniss;
	}

	public void setGesamtRichtigeErgebniss(Integer gesamtRichtigeErgebniss) {
		this.gesamtRichtigeErgebniss = gesamtRichtigeErgebniss;
	}

	private java.util.Date gameDate = new java.util.Date();
	private String stringDatum;
	private Date date;
	private Date time;
	private Date dtime;

	public Date getDtime() {
		return dtime;
	}

	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}

	private Date dtime2;
	private Date dtime3;
	private Date dtime4;
	private Date dtime5;
	private Date dtime6;
	private Date dtime7;
	private Date dtime8;
	private Date dtime9;
	private Date dtime10;
	private String aufgabeUndSchwierigkeit;
	private String aufgabeUndSchwierigkeit2;
	private String aufgabeUndSchwierigkeit3;
	private String aufgabeUndSchwierigkeit4;
	private String aufgabeUndSchwierigkeit5;
	private String aufgabeUndSchwierigkeit6;
	private String aufgabeUndSchwierigkeit7;
	private String aufgabeUndSchwierigkeit8;
	private String aufgabeUndSchwierigkeit9;
	private String aufgabeUndSchwierigkeit10;
	private Long id;
	private Integer Aufgabennummer_01;
	private Integer Aufgabennummer_02;
	private Integer Aufgabennummer_03;
	private Integer Aufgabennummer_04;
	private Integer Aufgabennummer_05;
	private Integer Aufgabennummer_06;
	private Integer Aufgabennummer_07;
	private Integer Aufgabennummer_08;
	private Integer Aufgabennummer_09;
	private Integer Aufgabennummer_10;

	private int userErgebnis_01;
	private int userErgebnis_02;
	private int userErgebnis_03;
	private int userErgebnis_04;
	private int userErgebnis_05;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getRightUserSolutions() {
        return rightUserSolutions;
    }

    public void setRightUserSolutions(int rightUserSolutions) {
        this.rightUserSolutions = rightUserSolutions;
    }

    public int getAverageGameTime() {
        return averageGameTime;
    }

    public void setAverageGameTime(int averageGameTime) {
        this.averageGameTime = averageGameTime;
    }

    public void setGesamtRichtigeErgebniss(int gesamtRichtigeErgebniss) {
        this.gesamtRichtigeErgebniss = gesamtRichtigeErgebniss;
    }

    public void setUserErgebnis_01(Integer userErgebnis_01) {
		this.userErgebnis_01 = userErgebnis_01;
	}

	public void setUserErgebnis_02(Integer userErgebnis_02) {
		this.userErgebnis_02 = userErgebnis_02;
	}

	public void setUserErgebnis_03(Integer userErgebnis_03) {
		this.userErgebnis_03 = userErgebnis_03;
	}

	public void setUserErgebnis_04(Integer userErgebnis_04) {
		this.userErgebnis_04 = userErgebnis_04;
	}

	public void setUserErgebnis_05(Integer userErgebnis_05) {
		this.userErgebnis_05 = userErgebnis_05;
	}

	public void setUserErgebnis_06(Integer userErgebnis_06) {
		this.userErgebnis_06 = userErgebnis_06;
	}

	public void setUserErgebnis_07(Integer userErgebnis_07) {
		this.userErgebnis_07 = userErgebnis_07;
	}

	public void setUserErgebnis_08(Integer userErgebnis_08) {
		this.userErgebnis_08 = userErgebnis_08;
	}

	public void setUserErgebnis_09(Integer userErgebnis_09) {
		this.userErgebnis_09 = userErgebnis_09;
	}

	public void setUserErgebnis_10(Integer userErgebnis_10) {
		this.userErgebnis_10 = userErgebnis_10;
	}

	private int userErgebnis_06;
	private int userErgebnis_07;
	private int userErgebnis_08;
	private int userErgebnis_09;
	private int userErgebnis_10;
	private int userErgebnis_richtig;
	private int userErgebnis_richtig2;
	private int userErgebnis_richtig3;
	private int userErgebnis_richtig4;
	private int userErgebnis_richtig5;
	private int userErgebnis_richtig6;
	private int userErgebnis_richtig7;
	private int userErgebnis_richtig8;
	private int userErgebnis_richtig9;

	private int userErgebnis_richtig10;
	private Date ergebnisDateTime;
	private long ergebnisTime;

	private Integer maxGameId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDatetime() {
		return dtime;
	}

	public void setDatetime(Date datetime) {
		this.dtime = datetime;
	}

	public Integer getMaxGameId() {
		return maxGameId;
	}

	public void setMaxGameId(Integer maxGameId) {
		this.maxGameId = maxGameId;
	}

	public long getSpiellaenge() {
		return spiellaenge;
	}

	public int getUserErgebnis_richtig10() {
		return userErgebnis_richtig10;
	}

	public void setUserErgebnis_richtig10(int userErgebnis_richtig10) {
		this.userErgebnis_richtig10 = userErgebnis_richtig10;
	}

	public Date getErgebnisDateTime() {
		return ergebnisDateTime;
	}

	public void setErgebnisDateTime(Date ergebnisDateTime) {
		this.ergebnisDateTime = ergebnisDateTime;
	}

	public long getErgebnisTime() {
		return ergebnisTime;
	}

	public void setErgebnisTime(long ergebnisTime) {
		this.ergebnisTime = ergebnisTime;
	}

	public void setSpiellaenge(long spiellaenge) {
		this.spiellaenge = spiellaenge;
	}

	public String getSchwierigkeit() {
		return schwierigkeit;
	}

	public void setSchwierigkeit(String schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

	public String getSpieltyp() {
		return spieltyp;
	}

	public void setSpieltyp(String spieltyp) {
		this.spieltyp = spieltyp;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getAufgabe_01() {
		return aufgabe_01;
	}

	public void setAufgabe_01(String aufgabe_01) {
		this.aufgabe_01 = aufgabe_01;
	}

	public int getLoesung_01() {
		return loesung_01;
	}

	public void setLoesung_01(int loesung_01) {
		this.loesung_01 = loesung_01;
	}

	public String getAufgabe_02() {
		return aufgabe_02;
	}

	public void setAufgabe_02(String aufgabe_02) {
		this.aufgabe_02 = aufgabe_02;
	}

	public int getLoesung_02() {
		return loesung_02;
	}

	public void setLoesung_02(int loesung_02) {
		this.loesung_02 = loesung_02;
	}

	public String getAufgabe_03() {
		return aufgabe_03;
	}

	public void setAufgabe_03(String aufgabe_03) {
		this.aufgabe_03 = aufgabe_03;
	}

	public int getLoesung_03() {
		return loesung_03;
	}

	public void setLoesung_03(int loesung_03) {
		this.loesung_03 = loesung_03;
	}

	public String getAufgabe_04() {
		return aufgabe_04;
	}

	public void setAufgabe_04(String aufgabe_04) {
		this.aufgabe_04 = aufgabe_04;
	}

	public int getLoesung_04() {
		return loesung_04;
	}

	public void setLoesung_04(int loesung_04) {
		this.loesung_04 = loesung_04;
	}

	public String getAufgabe_05() {
		return aufgabe_05;
	}

	public void setAufgabe_05(String aufgabe_05) {
		this.aufgabe_05 = aufgabe_05;
	}

	public int getLoesung_05() {
		return loesung_05;
	}

	public void setLoesung_05(int loesung_05) {
		this.loesung_05 = loesung_05;
	}

	public String getAufgabe_06() {
		return aufgabe_06;
	}

	public void setAufgabe_06(String aufgabe_06) {
		this.aufgabe_06 = aufgabe_06;
	}

	public int getLoesung_06() {
		return loesung_06;
	}

	public void setLoesung_06(int loesung_06) {
		this.loesung_06 = loesung_06;
	}

	public String getAufgabe_07() {
		return aufgabe_07;
	}

	public void setAufgabe_07(String aufgabe_07) {
		this.aufgabe_07 = aufgabe_07;
	}

	public int getLoesung_07() {
		return loesung_07;
	}

	public void setLoesung_07(int loesung_07) {
		this.loesung_07 = loesung_07;
	}

	public String getAufgabe_08() {
		return aufgabe_08;
	}

	public void setAufgabe_08(String aufgabe_08) {
		this.aufgabe_08 = aufgabe_08;
	}

	public int getLoesung_08() {
		return loesung_08;
	}

	public void setLoesung_08(int loesung_08) {
		this.loesung_08 = loesung_08;
	}

	public String getAufgabe_09() {
		return aufgabe_09;
	}

	public void setAufgabe_09(String aufgabe_09) {
		this.aufgabe_09 = aufgabe_09;
	}

	public int getLoesung_09() {
		return loesung_09;
	}

	public void setLoesung_09(int loesung_09) {
		this.loesung_09 = loesung_09;
	}

	public String getAufgabe_10() {
		return aufgabe_10;
	}

	public void setAufgabe_10(String aufgabe_10) {
		this.aufgabe_10 = aufgabe_10;
	}

	public int getLoesung_10() {
		return loesung_10;
	}

	public void setLoesung_10(int loesung_10) {
		this.loesung_10 = loesung_10;
	}

	public Date getDtime2() {
		return dtime2;
	}

	public void setDtime2(Date dtime2) {
		this.dtime2 = dtime2;
	}

	public Date getDtime3() {
		return dtime3;
	}

	public void setDtime3(Date dtime3) {
		this.dtime3 = dtime3;
	}

	public Date getDtime4() {
		return dtime4;
	}

	public void setDtime4(Date dtime4) {
		this.dtime4 = dtime4;
	}

	public Date getDtime5() {
		return dtime5;
	}

	public void setDtime5(Date dtime5) {
		this.dtime5 = dtime5;
	}

	public Date getDtime6() {
		return dtime6;
	}

	public void setDtime6(Date dtime6) {
		this.dtime6 = dtime6;
	}

	public Date getDtime7() {
		return dtime7;
	}

	public void setDtime7(Date dtime7) {
		this.dtime7 = dtime7;
	}

	public Date getDtime8() {
		return dtime8;
	}

	public void setDtime8(Date dtime8) {
		this.dtime8 = dtime8;
	}

	public Date getDtime9() {
		return dtime9;
	}

	public void setDtime9(Date dtime9) {
		this.dtime9 = dtime9;
	}

	public Date getDtime10() {
		return dtime10;
	}

	public void setDtime10(Date dtime10) {
		this.dtime10 = dtime10;
	}

	public String getAufgabeUndSchwierigkeit() {
		return aufgabeUndSchwierigkeit;
	}

	public void setAufgabeUndSchwierigkeit(String aufgabeUndSchwierigkeit) {
		this.aufgabeUndSchwierigkeit = aufgabeUndSchwierigkeit;
	}

	public String getAufgabeUndSchwierigkeit2() {
		return aufgabeUndSchwierigkeit2;
	}

	public void setAufgabeUndSchwierigkeit2(String aufgabeUndSchwierigkeit2) {
		this.aufgabeUndSchwierigkeit2 = aufgabeUndSchwierigkeit2;
	}

	public String getAufgabeUndSchwierigkeit3() {
		return aufgabeUndSchwierigkeit3;
	}

	public void setAufgabeUndSchwierigkeit3(String aufgabeUndSchwierigkeit3) {
		this.aufgabeUndSchwierigkeit3 = aufgabeUndSchwierigkeit3;
	}

	public String getAufgabeUndSchwierigkeit4() {
		return aufgabeUndSchwierigkeit4;
	}

	public void setAufgabeUndSchwierigkeit4(String aufgabeUndSchwierigkeit4) {
		this.aufgabeUndSchwierigkeit4 = aufgabeUndSchwierigkeit4;
	}

	public String getAufgabeUndSchwierigkeit5() {
		return aufgabeUndSchwierigkeit5;
	}

	public void setAufgabeUndSchwierigkeit5(String aufgabeUndSchwierigkeit5) {
		this.aufgabeUndSchwierigkeit5 = aufgabeUndSchwierigkeit5;
	}

	public String getAufgabeUndSchwierigkeit6() {
		return aufgabeUndSchwierigkeit6;
	}

	public void setAufgabeUndSchwierigkeit6(String aufgabeUndSchwierigkeit6) {
		this.aufgabeUndSchwierigkeit6 = aufgabeUndSchwierigkeit6;
	}

	public String getAufgabeUndSchwierigkeit7() {
		return aufgabeUndSchwierigkeit7;
	}

	public void setAufgabeUndSchwierigkeit7(String aufgabeUndSchwierigkeit7) {
		this.aufgabeUndSchwierigkeit7 = aufgabeUndSchwierigkeit7;
	}

	public String getAufgabeUndSchwierigkeit8() {
		return aufgabeUndSchwierigkeit8;
	}

	public void setAufgabeUndSchwierigkeit8(String aufgabeUndSchwierigkeit8) {
		this.aufgabeUndSchwierigkeit8 = aufgabeUndSchwierigkeit8;
	}

	public String getAufgabeUndSchwierigkeit9() {
		return aufgabeUndSchwierigkeit9;
	}

	public void setAufgabeUndSchwierigkeit9(String aufgabeUndSchwierigkeit9) {
		this.aufgabeUndSchwierigkeit9 = aufgabeUndSchwierigkeit9;
	}

	public String getAufgabeUndSchwierigkeit10() {
		return aufgabeUndSchwierigkeit10;
	}

	public void setAufgabeUndSchwierigkeit10(String aufgabeUndSchwierigkeit10) {
		this.aufgabeUndSchwierigkeit10 = aufgabeUndSchwierigkeit10;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAufgabennummer_01() {
		return Aufgabennummer_01;
	}

	public void setAufgabennummer_01(Integer aufgabennummer_01) {
		Aufgabennummer_01 = aufgabennummer_01;
	}

	public Integer getAufgabennummer_02() {
		return Aufgabennummer_02;
	}

	public void setAufgabennummer_02(Integer aufgabennummer_02) {
		Aufgabennummer_02 = aufgabennummer_02;
	}

	public Integer getAufgabennummer_03() {
		return Aufgabennummer_03;
	}

	public void setAufgabennummer_03(Integer aufgabennummer_03) {
		Aufgabennummer_03 = aufgabennummer_03;
	}

	public Integer getAufgabennummer_04() {
		return Aufgabennummer_04;
	}

	public void setAufgabennummer_04(Integer aufgabennummer_04) {
		Aufgabennummer_04 = aufgabennummer_04;
	}

	public Integer getAufgabennummer_05() {
		return Aufgabennummer_05;
	}

	public void setAufgabennummer_05(Integer aufgabennummer_05) {
		Aufgabennummer_05 = aufgabennummer_05;
	}

	public Integer getAufgabennummer_06() {
		return Aufgabennummer_06;
	}

	public void setAufgabennummer_06(Integer aufgabennummer_06) {
		Aufgabennummer_06 = aufgabennummer_06;
	}

	public Integer getAufgabennummer_07() {
		return Aufgabennummer_07;
	}

	public void setAufgabennummer_07(Integer aufgabennummer_07) {
		Aufgabennummer_07 = aufgabennummer_07;
	}

	public Integer getAufgabennummer_08() {
		return Aufgabennummer_08;
	}

	public void setAufgabennummer_08(Integer aufgabennummer_08) {
		Aufgabennummer_08 = aufgabennummer_08;
	}

	public Integer getAufgabennummer_09() {
		return Aufgabennummer_09;
	}

	public void setAufgabennummer_09(Integer aufgabennummer_09) {
		Aufgabennummer_09 = aufgabennummer_09;
	}

	public Integer getAufgabennummer_10() {
		return Aufgabennummer_10;
	}

	public void setAufgabennummer_10(Integer aufgabennummer_10) {
		Aufgabennummer_10 = aufgabennummer_10;
	}

	public int getUserErgebnis_01() {
		return userErgebnis_01;
	}

	public void setUserErgebnis_01(int userErgebnis_01) {
		this.userErgebnis_01 = userErgebnis_01;
	}

	public int getUserErgebnis_02() {
		return userErgebnis_02;
	}

	public void setUserErgebnis_02(int userErgebnis_02) {
		this.userErgebnis_02 = userErgebnis_02;
	}

	public int getUserErgebnis_03() {
		return userErgebnis_03;
	}

	public void setUserErgebnis_03(int userErgebnis_03) {
		this.userErgebnis_03 = userErgebnis_03;
	}

	public int getUserErgebnis_04() {
		return userErgebnis_04;
	}

	public void setUserErgebnis_04(int userErgebnis_04) {
		this.userErgebnis_04 = userErgebnis_04;
	}

	public int getUserErgebnis_05() {
		return userErgebnis_05;
	}

	public void setUserErgebnis_05(int userErgebnis_05) {
		this.userErgebnis_05 = userErgebnis_05;
	}

	public int getUserErgebnis_06() {
		return userErgebnis_06;
	}

	public void setUserErgebnis_06(int userErgebnis_06) {
		this.userErgebnis_06 = userErgebnis_06;
	}

	public int getUserErgebnis_07() {
		return userErgebnis_07;
	}

	public void setUserErgebnis_07(int userErgebnis_07) {
		this.userErgebnis_07 = userErgebnis_07;
	}

	public int getUserErgebnis_08() {
		return userErgebnis_08;
	}

	public void setUserErgebnis_08(int userErgebnis_08) {
		this.userErgebnis_08 = userErgebnis_08;
	}

	public int getUserErgebnis_09() {
		return userErgebnis_09;
	}

	public void setUserErgebnis_09(int userErgebnis_09) {
		this.userErgebnis_09 = userErgebnis_09;
	}

	public int getUserErgebnis_10() {
		return userErgebnis_10;
	}

	public void setUserErgebnis_10(int userErgebnis_10) {
		this.userErgebnis_10 = userErgebnis_10;
	}

	public int getUserErgebnis_richtig() {
		return userErgebnis_richtig;
	}

	public void setUserErgebnis_richtig(int userErgebnis_richtig) {
		this.userErgebnis_richtig = userErgebnis_richtig;
	}

	public int getUserErgebnis_richtig2() {
		return userErgebnis_richtig2;
	}

	public void setUserErgebnis_richtig2(int userErgebnis_richtig2) {
		this.userErgebnis_richtig2 = userErgebnis_richtig2;
	}

	public int getUserErgebnis_richtig3() {
		return userErgebnis_richtig3;
	}

	public void setUserErgebnis_richtig3(int userErgebnis_richtig3) {
		this.userErgebnis_richtig3 = userErgebnis_richtig3;
	}

	public int getUserErgebnis_richtig4() {
		return userErgebnis_richtig4;
	}

	public void setUserErgebnis_richtig4(int userErgebnis_richtig4) {
		this.userErgebnis_richtig4 = userErgebnis_richtig4;
	}

	public int getUserErgebnis_richtig5() {
		return userErgebnis_richtig5;
	}

	public void setUserErgebnis_richtig5(int userErgebnis_richtig5) {
		this.userErgebnis_richtig5 = userErgebnis_richtig5;
	}

	public int getUserErgebnis_richtig6() {
		return userErgebnis_richtig6;
	}

	public void setUserErgebnis_richtig6(int userErgebnis_richtig6) {
		this.userErgebnis_richtig6 = userErgebnis_richtig6;
	}

	public int getUserErgebnis_richtig7() {
		return userErgebnis_richtig7;
	}

	public void setUserErgebnis_richtig7(int userErgebnis_richtig7) {
		this.userErgebnis_richtig7 = userErgebnis_richtig7;
	}

	public int getUserErgebnis_richtig8() {
		return userErgebnis_richtig8;
	}

	public void setUserErgebnis_richtig8(int userErgebnis_richtig8) {
		this.userErgebnis_richtig8 = userErgebnis_richtig8;
	}

	public int getUserErgebnis_richtig9() {
		return userErgebnis_richtig9;
	}

	public void setUserErgebnis_richtig9(int userErgebnis_richtig9) {
		this.userErgebnis_richtig9 = userErgebnis_richtig9;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getStringDatum() {
		return stringDatum;
	}

	public void setStringDatum(String stringDatum) {
		this.stringDatum = stringDatum;
	}

	public saveGame() {
		super();
	}

}
