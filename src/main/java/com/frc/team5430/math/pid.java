package com.frc.team5430.math;

import javax.swing.JComponent;

import edu.wpi.first.math.MathSharedStore;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Timer;

public class pid implements Sendable {  
    private double kP_;
    private double kI_;
    private double kD_;
    private double error;
    private double lastError;
    private double errorSum;
    private double dT;
    private double errorRate;
    private double PIDoutput;
    private double lastTimestamp;
    static private int instances;
 
    public pid(){}

    public pid(double kP, double kI, double kD){
        this.kP_ = kP;
        this.kI_ = kI;
        this.kD_ = kD;
        
        instances++;
        SendableRegistry.addLW(this, "PID", instances);
        }

    public void setPID(double kP, double kI, double kD){
        this.kP_ = kP;
        this.kI_ = kI;
        this.kD_ = kD;  
    }

    public void close() {
        SendableRegistry.remove(this);
    }

    public double getkP(){
        return kP_;
    }

    public double getkI(){
        return kI_;
    }

    public double getkD(){
        return kD_;
    }
    public void setkP(double kP){
         kP_ = kP;
    }

    public void setkI(Double kI){
         kI_ = kI;
    }

    public void setkD(double kD){
         kD_ = kD;
    }
    
    public void setTimetamp(){
        lastTimestamp = Timer.getFPGATimestamp();
    }

  public double calc(double setpoint, double input){
    error = setpoint - input;
    dT = Timer.getFPGATimestamp() - lastTimestamp;
    errorSum += error * dT;
    errorRate = (error - lastError) / dT;
    PIDoutput = kP_ * error + kI_ * errorSum + kD_ * errorRate;
    //update values
    lastError = error;
    lastTimestamp = Timer.getFPGATimestamp();
    return PIDoutput;
  }

  public void reset(){
    error = 0;
    lastError = 0;
    lastTimestamp = 0;
  }

  @Override
  public void initSendable(SendableBuilder build){
    build.setSmartDashboardType("PID");
    build.addDoubleProperty("P", this::getkP, this::setkP);
    build.addDoubleProperty("I", this::getkI, this::setkI);
    build.addDoubleProperty("D", this::getkD, this::setkD);
  }
}

