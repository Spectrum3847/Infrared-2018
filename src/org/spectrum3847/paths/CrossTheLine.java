package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class CrossTheLine extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (10.00,0.00,0.00)
	
	public CrossTheLine() {
		this(false);
	}
			
    public CrossTheLine(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.594,11.888,10.000},
				{2.972,23.775,10.000},
				{8.321,53.494,10.000},
				{17.831,95.101,10.000},
				{32.691,148.595,10.000},
				{54.088,213.976,10.000},
				{83.213,291.245,10.000},
				{121.253,380.402,10.000},
				{169.398,481.446,10.000},
				{228.836,594.378,10.000},
				{300.755,719.198,10.000},
				{386.346,855.905,10.000},
				{486.796,1004.499,10.000},
				{603.294,1164.981,10.000},
				{737.029,1337.351,10.000},
				{889.190,1521.608,10.000},
				{1060.965,1717.753,10.000},
				{1252.949,1919.842,10.000},
				{1465.142,2121.930,10.000},
				{1697.544,2324.019,10.000},
				{1950.155,2526.107,10.000},
				{2222.974,2728.196,10.000},
				{2516.003,2930.284,10.000},
				{2829.240,3132.373,10.000},
				{3162.686,3334.462,10.000},
				{3516.341,3536.550,10.000},
				{3890.205,3738.639,10.000},
				{4284.278,3940.727,10.000},
				{4698.559,4142.816,10.000},
				{5133.050,4344.904,10.000},
				{5587.749,4546.993,10.000},
				{6062.657,4749.082,10.000},
				{6557.774,4951.170,10.000},
				{7073.100,5153.259,10.000},
				{7608.635,5355.347,10.000},
				{8164.379,5557.436,10.000},
				{8740.331,5759.525,10.000},
				{9336.492,5961.613,10.000},
				{9952.863,6163.702,10.000},
				{10589.442,6365.790,10.000},
				{11246.230,6567.879,10.000},
				{11923.226,6769.967,10.000},
				{12620.432,6972.056,10.000},
				{13337.846,7174.145,10.000},
				{14075.470,7376.233,10.000},
				{14833.302,7578.322,10.000},
				{15611.343,7780.410,10.000},
				{16409.593,7982.499,10.000},
				{17228.051,8184.588,10.000},
				{18066.719,8386.676,10.000},
				{18925.596,8588.765,10.000},
				{19804.681,8790.853,10.000},
				{20703.975,8992.942,10.000},
				{21623.478,9195.030,10.000},
				{22563.190,9397.119,10.000},
				{23523.111,9599.208,10.000},
				{24503.240,9801.296,10.000},
				{25503.579,10003.385,10.000},
				{26524.126,10205.473,10.000},
				{27564.882,10407.562,10.000},
				{28625.253,10603.707,10.000},
				{29704.049,10787.964,10.000},
				{30800.083,10960.334,10.000},
				{31912.164,11120.816,10.000},
				{33039.105,11269.410,10.000},
				{34179.717,11406.117,10.000},
				{35332.811,11530.937,10.000},
				{36497.198,11643.869,10.000},
				{37671.689,11744.913,10.000},
				{38855.096,11834.070,10.000},
				{40046.230,11911.339,10.000},
				{41243.902,11976.720,10.000},
				{42446.923,12030.214,10.000},
				{43654.105,12071.821,10.000},
				{44864.259,12101.540,10.000},
				{46076.196,12119.371,10.000},
				{47288.728,12125.315,10.000},
				{48501.259,12125.315,10.000},
				{49713.791,12125.315,10.000},
				{50926.322,12125.315,10.000},
				{52138.854,12125.315,10.000},
				{53351.385,12125.315,10.000},
				{54563.917,12125.315,10.000},
				{55776.448,12125.315,10.000},
				{56988.980,12125.315,10.000},
				{58201.511,12125.315,10.000},
				{59414.043,12125.315,10.000},
				{60626.574,12125.315,10.000},
				{61839.106,12125.315,10.000},
				{63051.637,12125.315,10.000},
				{64264.169,12125.315,10.000},
				{65476.700,12125.315,10.000},
				{66689.232,12125.315,10.000},
				{67901.763,12125.315,10.000},
				{69114.295,12125.315,10.000},
				{70326.826,12125.315,10.000},
				{71539.358,12125.315,10.000},
				{72751.889,12125.315,10.000},
				{73964.420,12125.315,10.000},
				{75176.952,12125.315,10.000},
				{76389.483,12125.315,10.000},
				{77602.015,12125.315,10.000},
				{78814.546,12125.315,10.000},
				{80027.078,12125.315,10.000},
				{81239.609,12125.315,10.000},
				{82452.141,12125.315,10.000},
				{83664.672,12125.315,10.000},
				{84877.204,12125.315,10.000},
				{86089.735,12125.315,10.000},
				{87302.267,12125.315,10.000},
				{88514.798,12125.315,10.000},
				{89727.330,12125.315,10.000},
				{90939.861,12125.315,10.000},
				{92152.393,12125.315,10.000},
				{93364.924,12125.315,10.000},
				{94577.456,12125.315,10.000},
				{95789.987,12125.315,10.000},
				{97002.519,12125.315,10.000},
				{98215.050,12125.315,10.000},
				{99427.582,12125.315,10.000},
				{100640.113,12125.315,10.000},
				{101852.645,12125.315,10.000},
				{103065.176,12125.315,10.000},
				{104277.708,12125.315,10.000},
				{105490.239,12125.315,10.000},
				{106702.771,12125.315,10.000},
				{107915.302,12125.315,10.000},
				{109127.833,12125.315,10.000},
				{110340.365,12125.315,10.000},
				{111552.896,12125.315,10.000},
				{112765.428,12125.315,10.000},
				{113977.959,12125.315,10.000},
				{115190.491,12125.315,10.000},
				{116403.022,12125.315,10.000},
				{117615.554,12125.315,10.000},
				{118828.085,12125.315,10.000},
				{120040.617,12125.315,10.000},
				{121253.148,12125.315,10.000},
				{122465.680,12125.315,10.000},
				{123678.211,12125.315,10.000},
				{124890.743,12125.315,10.000},
				{126103.274,12125.315,10.000},
				{127315.806,12125.315,10.000},
				{128528.337,12125.315,10.000},
				{129740.869,12125.315,10.000},
				{130953.400,12125.315,10.000},
				{132165.932,12125.315,10.000},
				{133378.463,12125.315,10.000},
				{134590.995,12125.315,10.000},
				{135803.526,12125.315,10.000},
				{137016.058,12125.315,10.000},
				{138228.589,12125.315,10.000},
				{139441.121,12125.315,10.000},
				{140653.652,12125.315,10.000},
				{141866.184,12125.315,10.000},
				{143078.715,12125.315,10.000},
				{144291.247,12125.315,10.000},
				{145503.778,12125.315,10.000},
				{146716.309,12125.315,10.000},
				{147928.841,12125.315,10.000},
				{149141.372,12125.315,10.000},
				{150353.904,12125.315,10.000},
				{151566.435,12125.315,10.000},
				{152778.967,12125.315,10.000},
				{153991.498,12125.315,10.000},
				{155204.030,12125.315,10.000},
				{156416.363,12123.334,10.000},
				{157627.706,12113.427,10.000},
				{158836.869,12091.633,10.000},
				{160042.664,12057.952,10.000},
				{161243.903,12012.383,10.000},
				{162439.395,11954.926,10.000},
				{163627.954,11885.582,10.000},
				{164808.389,11804.351,10.000},
				{165979.512,11711.231,10.000},
				{167140.134,11606.225,10.000},
				{168289.067,11489.330,10.000},
				{169425.122,11360.548,10.000},
				{170547.110,11219.879,10.000},
				{171653.842,11067.322,10.000},
				{172744.130,10902.877,10.000},
				{173816.784,10726.545,10.000},
				{174870.617,10538.325,10.000},
				{175904.637,10340.199,10.000},
				{176918.448,10138.110,10.000},
				{177912.050,9936.022,10.000},
				{178885.443,9733.933,10.000},
				{179838.628,9531.845,10.000},
				{180771.603,9329.756,10.000},
				{181684.370,9127.668,10.000},
				{182576.928,8925.579,10.000},
				{183449.277,8723.490,10.000},
				{184301.417,8521.402,10.000},
				{185133.349,8319.313,10.000},
				{185945.071,8117.225,10.000},
				{186736.585,7915.136,10.000},
				{187507.889,7713.047,10.000},
				{188258.985,7510.959,10.000},
				{188989.872,7308.870,10.000},
				{189700.551,7106.782,10.000},
				{190391.020,6904.693,10.000},
				{191061.280,6702.605,10.000},
				{191711.332,6500.516,10.000},
				{192341.175,6298.427,10.000},
				{192950.809,6096.339,10.000},
				{193540.234,5894.250,10.000},
				{194109.450,5692.162,10.000},
				{194658.457,5490.073,10.000},
				{195187.256,5287.985,10.000},
				{195695.845,5085.896,10.000},
				{196184.226,4883.807,10.000},
				{196652.398,4681.719,10.000},
				{197100.361,4479.630,10.000},
				{197528.115,4277.542,10.000},
				{197935.660,4075.453,10.000},
				{198322.997,3873.364,10.000},
				{198690.124,3671.276,10.000},
				{199037.043,3469.187,10.000},
				{199363.753,3267.099,10.000},
				{199670.254,3065.010,10.000},
				{199956.546,2862.922,10.000},
				{200222.629,2660.833,10.000},
				{200468.504,2458.744,10.000},
				{200694.169,2256.656,10.000},
				{200899.626,2054.567,10.000},
				{201084.874,1852.479,10.000},
				{201250.111,1652.371,10.000},
				{201396.130,1460.189,10.000},
				{201524.119,1279.894,10.000},
				{201635.268,1111.487,10.000},
				{201730.765,954.968,10.000},
				{201811.798,810.336,10.000},
				{201879.558,677.591,10.000},
				{201935.231,556.734,10.000},
				{201980.007,447.765,10.000},
				{202015.076,350.683,10.000},
				{202041.625,265.489,10.000},
				{202060.843,192.182,10.000},
				{202073.919,130.763,10.000},
				{202082.042,81.232,10.000},
				{202086.401,43.588,10.000},
				{202088.184,17.831,10.000},
				{202088.581,3.963,10.000},
				{202088.581,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.594,11.888,10.000},
				{2.972,23.775,10.000},
				{8.321,53.494,10.000},
				{17.831,95.101,10.000},
				{32.691,148.595,10.000},
				{54.088,213.976,10.000},
				{83.213,291.245,10.000},
				{121.253,380.402,10.000},
				{169.398,481.446,10.000},
				{228.836,594.378,10.000},
				{300.755,719.198,10.000},
				{386.346,855.905,10.000},
				{486.796,1004.499,10.000},
				{603.294,1164.981,10.000},
				{737.029,1337.351,10.000},
				{889.190,1521.608,10.000},
				{1060.965,1717.753,10.000},
				{1252.949,1919.842,10.000},
				{1465.142,2121.930,10.000},
				{1697.544,2324.019,10.000},
				{1950.155,2526.107,10.000},
				{2222.974,2728.196,10.000},
				{2516.003,2930.284,10.000},
				{2829.240,3132.373,10.000},
				{3162.686,3334.462,10.000},
				{3516.341,3536.550,10.000},
				{3890.205,3738.639,10.000},
				{4284.278,3940.727,10.000},
				{4698.559,4142.816,10.000},
				{5133.050,4344.904,10.000},
				{5587.749,4546.993,10.000},
				{6062.657,4749.082,10.000},
				{6557.774,4951.170,10.000},
				{7073.100,5153.259,10.000},
				{7608.635,5355.347,10.000},
				{8164.379,5557.436,10.000},
				{8740.331,5759.525,10.000},
				{9336.492,5961.613,10.000},
				{9952.863,6163.702,10.000},
				{10589.442,6365.790,10.000},
				{11246.230,6567.879,10.000},
				{11923.226,6769.967,10.000},
				{12620.432,6972.056,10.000},
				{13337.846,7174.145,10.000},
				{14075.470,7376.233,10.000},
				{14833.302,7578.322,10.000},
				{15611.343,7780.410,10.000},
				{16409.593,7982.499,10.000},
				{17228.051,8184.588,10.000},
				{18066.719,8386.676,10.000},
				{18925.596,8588.765,10.000},
				{19804.681,8790.853,10.000},
				{20703.975,8992.942,10.000},
				{21623.478,9195.030,10.000},
				{22563.190,9397.119,10.000},
				{23523.111,9599.208,10.000},
				{24503.240,9801.296,10.000},
				{25503.579,10003.385,10.000},
				{26524.126,10205.473,10.000},
				{27564.882,10407.562,10.000},
				{28625.253,10603.707,10.000},
				{29704.049,10787.964,10.000},
				{30800.083,10960.334,10.000},
				{31912.164,11120.816,10.000},
				{33039.105,11269.410,10.000},
				{34179.717,11406.117,10.000},
				{35332.811,11530.937,10.000},
				{36497.198,11643.869,10.000},
				{37671.689,11744.913,10.000},
				{38855.096,11834.070,10.000},
				{40046.230,11911.339,10.000},
				{41243.902,11976.720,10.000},
				{42446.923,12030.214,10.000},
				{43654.105,12071.821,10.000},
				{44864.259,12101.540,10.000},
				{46076.196,12119.371,10.000},
				{47288.728,12125.315,10.000},
				{48501.259,12125.315,10.000},
				{49713.791,12125.315,10.000},
				{50926.322,12125.315,10.000},
				{52138.854,12125.315,10.000},
				{53351.385,12125.315,10.000},
				{54563.917,12125.315,10.000},
				{55776.448,12125.315,10.000},
				{56988.980,12125.315,10.000},
				{58201.511,12125.315,10.000},
				{59414.043,12125.315,10.000},
				{60626.574,12125.315,10.000},
				{61839.106,12125.315,10.000},
				{63051.637,12125.315,10.000},
				{64264.169,12125.315,10.000},
				{65476.700,12125.315,10.000},
				{66689.232,12125.315,10.000},
				{67901.763,12125.315,10.000},
				{69114.295,12125.315,10.000},
				{70326.826,12125.315,10.000},
				{71539.358,12125.315,10.000},
				{72751.889,12125.315,10.000},
				{73964.420,12125.315,10.000},
				{75176.952,12125.315,10.000},
				{76389.483,12125.315,10.000},
				{77602.015,12125.315,10.000},
				{78814.546,12125.315,10.000},
				{80027.078,12125.315,10.000},
				{81239.609,12125.315,10.000},
				{82452.141,12125.315,10.000},
				{83664.672,12125.315,10.000},
				{84877.204,12125.315,10.000},
				{86089.735,12125.315,10.000},
				{87302.267,12125.315,10.000},
				{88514.798,12125.315,10.000},
				{89727.330,12125.315,10.000},
				{90939.861,12125.315,10.000},
				{92152.393,12125.315,10.000},
				{93364.924,12125.315,10.000},
				{94577.456,12125.315,10.000},
				{95789.987,12125.315,10.000},
				{97002.519,12125.315,10.000},
				{98215.050,12125.315,10.000},
				{99427.582,12125.315,10.000},
				{100640.113,12125.315,10.000},
				{101852.645,12125.315,10.000},
				{103065.176,12125.315,10.000},
				{104277.708,12125.315,10.000},
				{105490.239,12125.315,10.000},
				{106702.771,12125.315,10.000},
				{107915.302,12125.315,10.000},
				{109127.833,12125.315,10.000},
				{110340.365,12125.315,10.000},
				{111552.896,12125.315,10.000},
				{112765.428,12125.315,10.000},
				{113977.959,12125.315,10.000},
				{115190.491,12125.315,10.000},
				{116403.022,12125.315,10.000},
				{117615.554,12125.315,10.000},
				{118828.085,12125.315,10.000},
				{120040.617,12125.315,10.000},
				{121253.148,12125.315,10.000},
				{122465.680,12125.315,10.000},
				{123678.211,12125.315,10.000},
				{124890.743,12125.315,10.000},
				{126103.274,12125.315,10.000},
				{127315.806,12125.315,10.000},
				{128528.337,12125.315,10.000},
				{129740.869,12125.315,10.000},
				{130953.400,12125.315,10.000},
				{132165.932,12125.315,10.000},
				{133378.463,12125.315,10.000},
				{134590.995,12125.315,10.000},
				{135803.526,12125.315,10.000},
				{137016.058,12125.315,10.000},
				{138228.589,12125.315,10.000},
				{139441.121,12125.315,10.000},
				{140653.652,12125.315,10.000},
				{141866.184,12125.315,10.000},
				{143078.715,12125.315,10.000},
				{144291.247,12125.315,10.000},
				{145503.778,12125.315,10.000},
				{146716.309,12125.315,10.000},
				{147928.841,12125.315,10.000},
				{149141.372,12125.315,10.000},
				{150353.904,12125.315,10.000},
				{151566.435,12125.315,10.000},
				{152778.967,12125.315,10.000},
				{153991.498,12125.315,10.000},
				{155204.030,12125.315,10.000},
				{156416.363,12123.334,10.000},
				{157627.706,12113.427,10.000},
				{158836.869,12091.633,10.000},
				{160042.664,12057.952,10.000},
				{161243.903,12012.383,10.000},
				{162439.395,11954.926,10.000},
				{163627.954,11885.582,10.000},
				{164808.389,11804.351,10.000},
				{165979.512,11711.231,10.000},
				{167140.134,11606.225,10.000},
				{168289.067,11489.330,10.000},
				{169425.122,11360.548,10.000},
				{170547.110,11219.879,10.000},
				{171653.842,11067.322,10.000},
				{172744.130,10902.877,10.000},
				{173816.784,10726.545,10.000},
				{174870.617,10538.325,10.000},
				{175904.637,10340.199,10.000},
				{176918.448,10138.110,10.000},
				{177912.050,9936.022,10.000},
				{178885.443,9733.933,10.000},
				{179838.628,9531.845,10.000},
				{180771.603,9329.756,10.000},
				{181684.370,9127.668,10.000},
				{182576.928,8925.579,10.000},
				{183449.277,8723.490,10.000},
				{184301.417,8521.402,10.000},
				{185133.349,8319.313,10.000},
				{185945.071,8117.225,10.000},
				{186736.585,7915.136,10.000},
				{187507.889,7713.047,10.000},
				{188258.985,7510.959,10.000},
				{188989.872,7308.870,10.000},
				{189700.551,7106.782,10.000},
				{190391.020,6904.693,10.000},
				{191061.280,6702.605,10.000},
				{191711.332,6500.516,10.000},
				{192341.175,6298.427,10.000},
				{192950.809,6096.339,10.000},
				{193540.234,5894.250,10.000},
				{194109.450,5692.162,10.000},
				{194658.457,5490.073,10.000},
				{195187.256,5287.985,10.000},
				{195695.845,5085.896,10.000},
				{196184.226,4883.807,10.000},
				{196652.398,4681.719,10.000},
				{197100.361,4479.630,10.000},
				{197528.115,4277.542,10.000},
				{197935.660,4075.453,10.000},
				{198322.997,3873.364,10.000},
				{198690.124,3671.276,10.000},
				{199037.043,3469.187,10.000},
				{199363.753,3267.099,10.000},
				{199670.254,3065.010,10.000},
				{199956.546,2862.922,10.000},
				{200222.629,2660.833,10.000},
				{200468.504,2458.744,10.000},
				{200694.169,2256.656,10.000},
				{200899.626,2054.567,10.000},
				{201084.874,1852.479,10.000},
				{201250.111,1652.371,10.000},
				{201396.130,1460.189,10.000},
				{201524.119,1279.894,10.000},
				{201635.268,1111.487,10.000},
				{201730.765,954.968,10.000},
				{201811.798,810.336,10.000},
				{201879.558,677.591,10.000},
				{201935.231,556.734,10.000},
				{201980.007,447.765,10.000},
				{202015.076,350.683,10.000},
				{202041.625,265.489,10.000},
				{202060.843,192.182,10.000},
				{202073.919,130.763,10.000},
				{202082.042,81.232,10.000},
				{202086.401,43.588,10.000},
				{202088.184,17.831,10.000},
				{202088.581,3.963,10.000},
				{202088.581,0.000,10.000}
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