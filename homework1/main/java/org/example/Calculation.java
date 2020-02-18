package org.example;

public class Calculation {

    public int paymentPerHour;
    public int numOfHoursWorked;
    public int skillLevel;
    public int numOfHospitalsDays;
    public int usedSickDays;
    public int bonusMoney;

    public Calculation(int paymentPerHour, int numOfHoursWorked, int skillLevel, int numOfHospitalsDays, int usedSickDays, int bonusMoney) {
        this.paymentPerHour = paymentPerHour;
        this.numOfHoursWorked = numOfHoursWorked;
        this.skillLevel = skillLevel;
        this.numOfHospitalsDays = numOfHospitalsDays;
        this.usedSickDays = usedSickDays;
        this.bonusMoney = bonusMoney;
    }

    public int bonus() {
        if(bonusMoney < 0)
            try {
                throw new Exception("incorrect data in bonus");
            } catch (Exception e) {
                System.out.println(e);
            }
            finally {
                return 0;
            }
        else
            return skillLevel * bonusMoney;
    }

    public int salary() throws Exception {
        if(numOfHoursWorked <= 0 || paymentPerHour <= 0)
            throw new Exception("incorrect data in salary");
        return paymentPerHour * numOfHoursWorked;
    }

    public int paymentPerDay(){
        return paymentPerHour * 8;
    }

    public int medicalBill() {
        if(numOfHospitalsDays < usedSickDays)
            try {
                throw new Exception("incorrect data in medicalBill");
            } catch (Exception e) {
                System.out.println(e);
            }
            finally {
                return 0;
            }
        else
            return (numOfHospitalsDays - usedSickDays) * this.paymentPerDay();
    }

    public int summary() throws Exception {
        return this.bonus() + this.salary() + this.medicalBill();
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public int getNumOfHoursWorked() {
        return numOfHoursWorked;
    }

    public void setNumOfHoursWorked(int numOfHoursWorked) {
        this.numOfHoursWorked = numOfHoursWorked;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getNumOfHospitalsDays() {
        return numOfHospitalsDays;
    }

    public void setNumOfHospitalsDays(int numOfHospitalsDays) {
        this.numOfHospitalsDays = numOfHospitalsDays;
    }

    public int getUsedSickDays() {
        return usedSickDays;
    }

    public void setUsedSickDays(int usedSickDays) {
        this.usedSickDays = usedSickDays;
    }

    public int getBonusMoney() {
        return bonusMoney;
    }

    public void setBonusMoney(int bonusMoney) {
        this.bonusMoney = bonusMoney;
    }
}
