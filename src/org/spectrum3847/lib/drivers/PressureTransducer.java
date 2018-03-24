package org.spectrum3847.lib.drivers;

import edu.wpi.first.wpilibj.AnalogInput;;

public class PressureTransducer extends AnalogInput{
	
	public PressureTransducer(int channel){
		super(channel);
		this.setAverageBits(4);
		this.setOversampleBits(2);
		
	}
	
	public double getPressure() {
		return (this.getAverageVoltage() - .52) * 37.5;
	}
	
	public boolean canShoot() {
		return (getPressure() > 60);
	}
	

}
