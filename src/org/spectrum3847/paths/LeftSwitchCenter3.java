package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class LeftSwitchCenter3 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (4.50,0.00,0.00)
	
	public LeftSwitchCenter3() {
		this(false);
	}
			
    public LeftSwitchCenter3(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.595,11.908,10.000},
				{2.977,23.815,10.000},
				{8.335,53.584,10.000},
				{17.861,95.261,10.000},
				{32.746,148.845,10.000},
				{54.180,214.337,10.000},
				{83.353,291.736,10.000},
				{121.458,381.043,10.000},
				{169.683,482.258,10.000},
				{229.221,595.380,10.000},
				{301.262,720.410,10.000},
				{386.997,857.347,10.000},
				{487.616,1006.192,10.000},
				{604.311,1166.945,10.000},
				{738.271,1339.605,10.000},
				{890.689,1524.173,10.000},
				{1062.753,1720.648,10.000},
				{1255.657,1929.031,10.000},
				{1470.589,2149.322,10.000},
				{1708.741,2381.520,10.000},
				{1970.708,2619.672,10.000},
				{2256.490,2857.824,10.000},
				{2566.088,3095.976,10.000},
				{2899.501,3334.128,10.000},
				{3256.729,3572.280,10.000},
				{3637.772,3810.432,10.000},
				{4042.631,4048.584,10.000},
				{4471.304,4286.736,10.000},
				{4923.793,4524.888,10.000},
				{5400.097,4763.040,10.000},
				{5900.216,5001.192,10.000},
				{6424.151,5239.344,10.000},
				{6971.900,5477.496,10.000},
				{7543.465,5715.648,10.000},
				{8138.845,5953.800,10.000},
				{8758.041,6191.953,10.000},
				{9401.051,6430.105,10.000},
				{10067.877,6668.257,10.000},
				{10758.517,6906.409,10.000},
				{11472.974,7144.561,10.000},
				{12211.245,7382.713,10.000},
				{12973.331,7620.865,10.000},
				{13759.233,7859.017,10.000},
				{14568.950,8097.169,10.000},
				{15402.482,8335.321,10.000},
				{16259.829,8573.473,10.000},
				{17140.992,8811.625,10.000},
				{18045.969,9049.777,10.000},
				{18974.762,9287.929,10.000},
				{19927.370,9526.081,10.000},
				{20903.793,9764.233,10.000},
				{21904.032,10002.385,10.000},
				{22928.086,10240.537,10.000},
				{23975.359,10472.735,10.000},
				{25044.662,10693.026,10.000},
				{26134.803,10901.409,10.000},
				{27244.591,11097.884,10.000},
				{28372.836,11282.452,10.000},
				{29518.347,11455.112,10.000},
				{30679.934,11615.865,10.000},
				{31856.405,11764.710,10.000},
				{33046.570,11901.647,10.000},
				{34249.237,12026.677,10.000},
				{35463.217,12139.799,10.000},
				{36687.319,12241.014,10.000},
				{37920.351,12330.321,10.000},
				{39161.123,12407.720,10.000},
				{40408.444,12473.212,10.000},
				{41661.124,12526.796,10.000},
				{42917.971,12568.473,10.000},
				{44177.795,12598.242,10.000},
				{45439.405,12616.103,10.000},
				{46701.044,12616.391,10.000},
				{47960.955,12599.106,10.000},
				{49217.946,12569.913,10.000},
				{50470.827,12528.812,10.000},
				{51718.408,12475.804,10.000},
				{52959.497,12410.888,10.000},
				{54192.903,12334.064,10.000},
				{55417.436,12245.333,10.000},
				{56631.906,12144.695,10.000},
				{57835.121,12032.148,10.000},
				{59025.890,11907.695,10.000},
				{60203.024,11771.333,10.000},
				{61365.330,11623.064,10.000},
				{62511.619,11462.887,10.000},
				{63640.699,11290.803,10.000},
				{64751.380,11106.811,10.000},
				{65842.471,10910.912,10.000},
				{66912.782,10703.105,10.000},
				{67961.121,10483.390,10.000},
				{68986.298,10251.768,10.000},
				{69987.688,10013.904,10.000},
				{70965.263,9775.752,10.000},
				{71919.023,9537.600,10.000},
				{72848.968,9299.448,10.000},
				{73755.097,9061.296,10.000},
				{74637.412,8823.144,10.000},
				{75495.911,8584.992,10.000},
				{76330.595,8346.840,10.000},
				{77141.464,8108.688,10.000},
				{77928.517,7870.536,10.000},
				{78691.756,7632.384,10.000},
				{79431.179,7394.232,10.000},
				{80146.787,7156.080,10.000},
				{80838.580,6917.928,10.000},
				{81506.557,6679.776,10.000},
				{82150.719,6441.624,10.000},
				{82771.067,6203.471,10.000},
				{83367.599,5965.319,10.000},
				{83940.315,5727.167,10.000},
				{84489.217,5489.015,10.000},
				{85014.303,5250.863,10.000},
				{85515.574,5012.711,10.000},
				{85993.030,4774.559,10.000},
				{86446.671,4536.407,10.000},
				{86876.497,4298.255,10.000},
				{87282.507,4060.103,10.000},
				{87664.702,3821.951,10.000},
				{88023.082,3583.799,10.000},
				{88357.647,3345.647,10.000},
				{88668.396,3107.495,10.000},
				{88955.330,2869.343,10.000},
				{89218.450,2631.191,10.000},
				{89457.754,2393.039,10.000},
				{89673.809,2160.553,10.000},
				{89867.777,1939.686,10.000},
				{90040.850,1730.727,10.000},
				{90194.218,1533.676,10.000},
				{90329.071,1348.532,10.000},
				{90446.601,1175.296,10.000},
				{90547.997,1013.968,10.000},
				{90634.452,864.547,10.000},
				{90707.155,727.033,10.000},
				{90767.298,601.428,10.000},
				{90816.071,487.729,10.000},
				{90854.665,385.939,10.000},
				{90884.271,296.056,10.000},
				{90906.079,218.080,10.000},
				{90921.280,152.013,10.000},
				{90931.065,97.853,10.000},
				{90936.625,55.600,10.000},
				{90939.151,25.255,10.000},
				{90939.832,6.818,10.000},
				{90939.861,0.288,10.000},
				{90939.861,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.595,11.908,10.000},
				{2.977,23.815,10.000},
				{8.335,53.584,10.000},
				{17.861,95.261,10.000},
				{32.746,148.845,10.000},
				{54.180,214.337,10.000},
				{83.353,291.736,10.000},
				{121.458,381.043,10.000},
				{169.683,482.258,10.000},
				{229.221,595.380,10.000},
				{301.262,720.410,10.000},
				{386.997,857.347,10.000},
				{487.616,1006.192,10.000},
				{604.311,1166.945,10.000},
				{738.271,1339.605,10.000},
				{890.689,1524.173,10.000},
				{1062.753,1720.648,10.000},
				{1255.657,1929.031,10.000},
				{1470.589,2149.322,10.000},
				{1708.741,2381.520,10.000},
				{1970.708,2619.672,10.000},
				{2256.490,2857.824,10.000},
				{2566.088,3095.976,10.000},
				{2899.501,3334.128,10.000},
				{3256.729,3572.280,10.000},
				{3637.772,3810.432,10.000},
				{4042.631,4048.584,10.000},
				{4471.304,4286.736,10.000},
				{4923.793,4524.888,10.000},
				{5400.097,4763.040,10.000},
				{5900.216,5001.192,10.000},
				{6424.151,5239.344,10.000},
				{6971.900,5477.496,10.000},
				{7543.465,5715.648,10.000},
				{8138.845,5953.800,10.000},
				{8758.041,6191.953,10.000},
				{9401.051,6430.105,10.000},
				{10067.877,6668.257,10.000},
				{10758.517,6906.409,10.000},
				{11472.974,7144.561,10.000},
				{12211.245,7382.713,10.000},
				{12973.331,7620.865,10.000},
				{13759.233,7859.017,10.000},
				{14568.950,8097.169,10.000},
				{15402.482,8335.321,10.000},
				{16259.829,8573.473,10.000},
				{17140.992,8811.625,10.000},
				{18045.969,9049.777,10.000},
				{18974.762,9287.929,10.000},
				{19927.370,9526.081,10.000},
				{20903.793,9764.233,10.000},
				{21904.032,10002.385,10.000},
				{22928.086,10240.537,10.000},
				{23975.359,10472.735,10.000},
				{25044.662,10693.026,10.000},
				{26134.803,10901.409,10.000},
				{27244.591,11097.884,10.000},
				{28372.836,11282.452,10.000},
				{29518.347,11455.112,10.000},
				{30679.934,11615.865,10.000},
				{31856.405,11764.710,10.000},
				{33046.570,11901.647,10.000},
				{34249.237,12026.677,10.000},
				{35463.217,12139.799,10.000},
				{36687.319,12241.014,10.000},
				{37920.351,12330.321,10.000},
				{39161.123,12407.720,10.000},
				{40408.444,12473.212,10.000},
				{41661.124,12526.796,10.000},
				{42917.971,12568.473,10.000},
				{44177.795,12598.242,10.000},
				{45439.405,12616.103,10.000},
				{46701.044,12616.391,10.000},
				{47960.955,12599.106,10.000},
				{49217.946,12569.913,10.000},
				{50470.827,12528.812,10.000},
				{51718.408,12475.804,10.000},
				{52959.497,12410.888,10.000},
				{54192.903,12334.064,10.000},
				{55417.436,12245.333,10.000},
				{56631.906,12144.695,10.000},
				{57835.121,12032.148,10.000},
				{59025.890,11907.695,10.000},
				{60203.024,11771.333,10.000},
				{61365.330,11623.064,10.000},
				{62511.619,11462.887,10.000},
				{63640.699,11290.803,10.000},
				{64751.380,11106.811,10.000},
				{65842.471,10910.912,10.000},
				{66912.782,10703.105,10.000},
				{67961.121,10483.390,10.000},
				{68986.298,10251.768,10.000},
				{69987.688,10013.904,10.000},
				{70965.263,9775.752,10.000},
				{71919.023,9537.600,10.000},
				{72848.968,9299.448,10.000},
				{73755.097,9061.296,10.000},
				{74637.412,8823.144,10.000},
				{75495.911,8584.992,10.000},
				{76330.595,8346.840,10.000},
				{77141.464,8108.688,10.000},
				{77928.517,7870.536,10.000},
				{78691.756,7632.384,10.000},
				{79431.179,7394.232,10.000},
				{80146.787,7156.080,10.000},
				{80838.580,6917.928,10.000},
				{81506.557,6679.776,10.000},
				{82150.719,6441.624,10.000},
				{82771.067,6203.471,10.000},
				{83367.599,5965.319,10.000},
				{83940.315,5727.167,10.000},
				{84489.217,5489.015,10.000},
				{85014.303,5250.863,10.000},
				{85515.574,5012.711,10.000},
				{85993.030,4774.559,10.000},
				{86446.671,4536.407,10.000},
				{86876.497,4298.255,10.000},
				{87282.507,4060.103,10.000},
				{87664.702,3821.951,10.000},
				{88023.082,3583.799,10.000},
				{88357.647,3345.647,10.000},
				{88668.396,3107.495,10.000},
				{88955.330,2869.343,10.000},
				{89218.450,2631.191,10.000},
				{89457.754,2393.039,10.000},
				{89673.809,2160.553,10.000},
				{89867.777,1939.686,10.000},
				{90040.850,1730.727,10.000},
				{90194.218,1533.676,10.000},
				{90329.071,1348.532,10.000},
				{90446.601,1175.296,10.000},
				{90547.997,1013.968,10.000},
				{90634.452,864.547,10.000},
				{90707.155,727.033,10.000},
				{90767.298,601.428,10.000},
				{90816.071,487.729,10.000},
				{90854.665,385.939,10.000},
				{90884.271,296.056,10.000},
				{90906.079,218.080,10.000},
				{90921.280,152.013,10.000},
				{90931.065,97.853,10.000},
				{90936.625,55.600,10.000},
				{90939.151,25.255,10.000},
				{90939.832,6.818,10.000},
				{90939.861,0.288,10.000},
				{90939.861,0.000,10.000}
		};
		
		if (flipped) {
			rightProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			leftProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		} else {
			leftProfile = new SrxMotionProfile(leftPoints.length, leftPoints);
			rightProfile = new SrxMotionProfile(rightPoints.length, rightPoints);
		}
	}

}