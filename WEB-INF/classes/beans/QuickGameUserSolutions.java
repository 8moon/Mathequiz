//Erstellt von Kahraman Ali und Theinert Thomas

package beans;

import java.io.Serializable;
import java.util.Date;

public class QuickGameUserSolutions implements Serializable{

    private int userSolution_01;
    private int userSolution_02;
    private int userSolution_03;
    private int userSolution_04;
    private int userSolution_05;
    private int userSolution_06;
    private int userSolution_07;
    private int userSolution_08;
    private int userSolution_09;
    private int userSolution_10;
    private int rightUserSolutions;
    private Date solutionDateTime;
    private long solutionTime;

    public QuickGameUserSolutions() {
    }

    public int getUserSolution_01() {
        return userSolution_01;
    }

    public void setUserSolution_01(int userSolution_01) {
        this.userSolution_01 = userSolution_01;
    }

    public int getUserSolution_02() {
        return userSolution_02;
    }

    public void setUserSolution_02(int userSolution_02) {
        this.userSolution_02 = userSolution_02;
    }

    public int getUserSolution_03() {
        return userSolution_03;
    }

    public void setUserSolution_03(int userSolution_03) {
        this.userSolution_03 = userSolution_03;
    }

    public int getRightUserSolutions() {
        return rightUserSolutions;
    }

    public void setRightUserSolutions(int rightUserSolutions) {
        this.rightUserSolutions = rightUserSolutions;
    }

    public int getUserSolution_04() {
        return userSolution_04;
    }

    public void setUserSolution_04(int userSolution_04) {
        this.userSolution_04 = userSolution_04;
    }

    public int getUserSolution_05() {
        return userSolution_05;
    }

    public void setUserSolution_05(int userSolution_05) {
        this.userSolution_05 = userSolution_05;
    }

    public int getUserSolution_06() {
        return userSolution_06;
    }

    public void setUserSolution_06(int userSolution_06) {
        this.userSolution_06 = userSolution_06;
    }

    public int getUserSolution_07() {
        return userSolution_07;
    }

    public void setUserSolution_07(int userSolution_07) {
        this.userSolution_07 = userSolution_07;
    }

    public int getUserSolution_08() {
        return userSolution_08;
    }

    public void setUserSolution_08(int userSolution_08) {
        this.userSolution_08 = userSolution_08;
    }

    public int getUserSolution_09() {
        return userSolution_09;
    }

    public void setUserSolution_09(int userSolution_09) {
        this.userSolution_09 = userSolution_09;
    }

    public int getUserSolution_10() {
        return userSolution_10;
    }

    public void setUserSolution_10(int userSolution_10) {
        this.userSolution_10 = userSolution_10;
    }

    public Date getSolutionDateTime() {
        return solutionDateTime;
    }

    public void setSolutionDateTime(Date solutionDateTime) {
        this.solutionDateTime = solutionDateTime;
    }

    public void setSolutionTime(long solutionTime) {
        this.solutionTime = solutionTime;
    }

    public long getSolutionTime() {
        return solutionTime;
    }
}
