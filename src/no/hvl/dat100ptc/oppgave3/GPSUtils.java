package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {
	public static double findMax(double[] da) {
		double max; 
		max = da[0];
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}
	public static double findMin(double[] da) {
		double min;
		// TODO - START
		min = da[0];
			for (double d : da) {
				if (d < min) {
					min = d;
				}
			}
		return min;
		// TODO - SLUT
	}
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		// TODO - START
		double[] latitude = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitude[i] = gpspoints[i].getLatitude();
		}
		return latitude;

		
		// TODO - SLUTT
	}
	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		// TODO - START
		double[] longitudetude = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudetude[i] = gpspoints[i].getLongitude();
		}
		return longitudetude;
		// TODO - SLUTT
	}
	private static int R = 6371000; // jordens radius
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = toRadians(gpspoint1.getLatitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude1 = toRadians(gpspoint1.getLongitude());
		longitude2 = toRadians(gpspoint2.getLongitude());

		
		double aq = (latitude2 - latitude1);
		double aa = (longitude2 - longitude1);
		double a = pow((sin(aq/2)),2) + cos(latitude1)* cos(latitude2) * pow(sin(aa/2),2);
		double c = 2 * atan2(sqrt(a),sqrt(1-a));
		double d = R * c;
		return d;

		

		

		

		
		// TODO - START


		
		// TODO - SLUTT
	}
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		int secs;
		double speed;
		// TODO - START
		 int tid1 = gpspoint1.getTime() ;
		 int tid2 = gpspoint2.getTime();
		 secs = tid2 - tid1;
		 double d = distance(gpspoint1,gpspoint2);

		 

		 
		 speed =  d/secs * 3600.0/ 1000;
		 return speed;
		// TODO - SLUTT
	}
	public static String formatTime(int secs) {
		String timestr;
		String TIMESEP = ":";
		// TODO - START
		int hh = secs / 3600;
		int rest = secs % 3600;
		int mm = rest / 60;
		int ss = rest % 60;
		String hhstr = String.format("%02d", hh);
		String mmstr = String.format("%02d", mm);
		String ssstr = String.format("%02d", ss);
		timestr = String.format("  %s%s%s%s%s", hhstr, TIMESEP, mmstr, TIMESEP, ssstr);
		return timestr;
		// TODO - SLUTT
	}
	private static int TEXTWIDTH = 10;
	public static String formatDouble(double d) {
		String str = null;
		str = String.format("%"+TEXTWIDTH +".2f", d).replaceAll(",", ".");
		// TODO - START

		// TODO - SLUTT
		return str;
		
	}
}