package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class CenterToLeftSwitchPt5 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (6.50,0.00,0.00)
	
	public CenterToLeftSwitchPt5() {
		this(false);
	}
			
    public CenterToLeftSwitchPt5(boolean flipped) {
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
				{11245.635,6561.935,10.000},
				{11920.254,6746.192,10.000},
				{12612.111,6918.562,10.000},
				{13320.015,7079.044,10.000},
				{14042.779,7227.639,10.000},
				{14779.213,7364.346,10.000},
				{15528.130,7489.165,10.000},
				{16288.340,7602.097,10.000},
				{17058.654,7703.141,10.000},
				{17837.884,7792.298,10.000},
				{18624.840,7869.567,10.000},
				{19418.335,7934.949,10.000},
				{20217.179,7988.443,10.000},
				{21020.184,8030.049,10.000},
				{21826.161,8059.768,10.000},
				{22633.921,8077.599,10.000},
				{23442.275,8083.543,10.000},
				{24250.630,8083.543,10.000},
				{25058.984,8083.543,10.000},
				{25867.338,8083.543,10.000},
				{26675.693,8083.543,10.000},
				{27484.047,8083.543,10.000},
				{28292.401,8083.543,10.000},
				{29100.756,8083.543,10.000},
				{29909.110,8083.543,10.000},
				{30717.464,8083.543,10.000},
				{31525.819,8083.543,10.000},
				{32334.173,8083.543,10.000},
				{33142.527,8083.543,10.000},
				{33950.882,8083.543,10.000},
				{34759.236,8083.543,10.000},
				{35567.590,8083.543,10.000},
				{36375.944,8083.543,10.000},
				{37184.299,8083.543,10.000},
				{37992.653,8083.543,10.000},
				{38801.007,8083.543,10.000},
				{39609.362,8083.543,10.000},
				{40417.716,8083.543,10.000},
				{41226.070,8083.543,10.000},
				{42034.425,8083.543,10.000},
				{42842.779,8083.543,10.000},
				{43651.133,8083.543,10.000},
				{44459.488,8083.543,10.000},
				{45267.842,8083.543,10.000},
				{46076.196,8083.543,10.000},
				{46884.551,8083.543,10.000},
				{47692.905,8083.543,10.000},
				{48501.259,8083.543,10.000},
				{49309.614,8083.543,10.000},
				{50117.968,8083.543,10.000},
				{50926.322,8083.543,10.000},
				{51734.677,8083.543,10.000},
				{52543.031,8083.543,10.000},
				{53351.385,8083.543,10.000},
				{54159.740,8083.543,10.000},
				{54968.094,8083.543,10.000},
				{55776.448,8083.543,10.000},
				{56584.803,8083.543,10.000},
				{57393.157,8083.543,10.000},
				{58201.511,8083.543,10.000},
				{59009.866,8083.543,10.000},
				{59818.220,8083.543,10.000},
				{60626.574,8083.543,10.000},
				{61434.928,8083.543,10.000},
				{62243.283,8083.543,10.000},
				{63051.637,8083.543,10.000},
				{63859.991,8083.543,10.000},
				{64668.346,8083.543,10.000},
				{65476.700,8083.543,10.000},
				{66285.054,8083.543,10.000},
				{67093.409,8083.543,10.000},
				{67901.763,8083.543,10.000},
				{68710.117,8083.543,10.000},
				{69518.472,8083.543,10.000},
				{70326.826,8083.543,10.000},
				{71135.180,8083.543,10.000},
				{71943.535,8083.543,10.000},
				{72751.889,8083.543,10.000},
				{73560.243,8083.543,10.000},
				{74368.598,8083.543,10.000},
				{75176.952,8083.543,10.000},
				{75985.306,8083.543,10.000},
				{76793.661,8083.543,10.000},
				{77602.015,8083.543,10.000},
				{78410.369,8083.543,10.000},
				{79218.724,8083.543,10.000},
				{80027.078,8083.543,10.000},
				{80835.432,8083.543,10.000},
				{81643.787,8083.543,10.000},
				{82452.141,8083.543,10.000},
				{83260.495,8083.543,10.000},
				{84068.850,8083.543,10.000},
				{84877.204,8083.543,10.000},
				{85685.558,8083.543,10.000},
				{86493.912,8083.543,10.000},
				{87302.267,8083.543,10.000},
				{88110.621,8083.543,10.000},
				{88918.975,8083.543,10.000},
				{89727.330,8083.543,10.000},
				{90535.684,8083.543,10.000},
				{91344.038,8083.543,10.000},
				{92152.393,8083.543,10.000},
				{92960.747,8083.543,10.000},
				{93769.101,8083.543,10.000},
				{94577.456,8083.543,10.000},
				{95385.810,8083.543,10.000},
				{96194.164,8083.543,10.000},
				{97002.519,8083.543,10.000},
				{97810.873,8083.543,10.000},
				{98619.227,8083.543,10.000},
				{99427.582,8083.543,10.000},
				{100235.936,8083.543,10.000},
				{101044.290,8083.543,10.000},
				{101852.645,8083.543,10.000},
				{102660.999,8083.543,10.000},
				{103469.353,8083.543,10.000},
				{104277.708,8083.543,10.000},
				{105086.062,8083.543,10.000},
				{105894.416,8083.543,10.000},
				{106702.771,8083.543,10.000},
				{107511.125,8083.543,10.000},
				{108319.479,8083.543,10.000},
				{109127.536,8080.571,10.000},
				{109934.405,8068.684,10.000},
				{110738.896,8044.909,10.000},
				{111539.820,8009.246,10.000},
				{112335.990,7961.696,10.000},
				{113126.215,7902.258,10.000},
				{113909.309,7830.932,10.000},
				{114684.081,7747.720,10.000},
				{115449.343,7652.619,10.000},
				{116203.906,7545.631,10.000},
				{116946.581,7426.755,10.000},
				{117676.180,7295.992,10.000},
				{118391.515,7153.341,10.000},
				{119091.395,6998.803,10.000},
				{119774.633,6832.377,10.000},
				{120440.039,6654.064,10.000},
				{121086.425,6463.863,10.000},
				{121712.900,6264.746,10.000},
				{122319.166,6062.657,10.000},
				{122905.222,5860.569,10.000},
				{123471.070,5658.480,10.000},
				{124016.710,5456.392,10.000},
				{124542.140,5254.303,10.000},
				{125047.361,5052.215,10.000},
				{125532.374,4850.126,10.000},
				{125997.178,4648.037,10.000},
				{126441.773,4445.949,10.000},
				{126866.159,4243.860,10.000},
				{127270.336,4041.772,10.000},
				{127654.304,3839.683,10.000},
				{128018.064,3637.594,10.000},
				{128361.614,3435.506,10.000},
				{128684.956,3233.417,10.000},
				{128988.089,3031.329,10.000},
				{129271.013,2829.240,10.000},
				{129533.728,2627.152,10.000},
				{129776.234,2425.063,10.000},
				{129998.532,2222.974,10.000},
				{130200.620,2020.886,10.000},
				{130382.500,1818.797,10.000},
				{130544.468,1619.681,10.000},
				{130687.416,1429.480,10.000},
				{130812.533,1251.166,10.000},
				{130921.007,1084.740,10.000},
				{131014.027,930.202,10.000},
				{131092.782,787.551,10.000},
				{131158.461,656.788,10.000},
				{131212.252,537.912,10.000},
				{131255.344,430.924,10.000},
				{131288.927,335.824,10.000},
				{131314.188,252.611,10.000},
				{131332.316,181.285,10.000},
				{131344.501,121.848,10.000},
				{131351.931,74.297,10.000},
				{131355.794,38.635,10.000},
				{131357.280,14.859,10.000},
				{131357.577,2.972,10.000},
				{131357.577,0.000,10.000}
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
				{11245.635,6561.935,10.000},
				{11920.254,6746.192,10.000},
				{12612.111,6918.562,10.000},
				{13320.015,7079.044,10.000},
				{14042.779,7227.639,10.000},
				{14779.213,7364.346,10.000},
				{15528.130,7489.165,10.000},
				{16288.340,7602.097,10.000},
				{17058.654,7703.141,10.000},
				{17837.884,7792.298,10.000},
				{18624.840,7869.567,10.000},
				{19418.335,7934.949,10.000},
				{20217.179,7988.443,10.000},
				{21020.184,8030.049,10.000},
				{21826.161,8059.768,10.000},
				{22633.921,8077.599,10.000},
				{23442.275,8083.543,10.000},
				{24250.630,8083.543,10.000},
				{25058.984,8083.543,10.000},
				{25867.338,8083.543,10.000},
				{26675.693,8083.543,10.000},
				{27484.047,8083.543,10.000},
				{28292.401,8083.543,10.000},
				{29100.756,8083.543,10.000},
				{29909.110,8083.543,10.000},
				{30717.464,8083.543,10.000},
				{31525.819,8083.543,10.000},
				{32334.173,8083.543,10.000},
				{33142.527,8083.543,10.000},
				{33950.882,8083.543,10.000},
				{34759.236,8083.543,10.000},
				{35567.590,8083.543,10.000},
				{36375.944,8083.543,10.000},
				{37184.299,8083.543,10.000},
				{37992.653,8083.543,10.000},
				{38801.007,8083.543,10.000},
				{39609.362,8083.543,10.000},
				{40417.716,8083.543,10.000},
				{41226.070,8083.543,10.000},
				{42034.425,8083.543,10.000},
				{42842.779,8083.543,10.000},
				{43651.133,8083.543,10.000},
				{44459.488,8083.543,10.000},
				{45267.842,8083.543,10.000},
				{46076.196,8083.543,10.000},
				{46884.551,8083.543,10.000},
				{47692.905,8083.543,10.000},
				{48501.259,8083.543,10.000},
				{49309.614,8083.543,10.000},
				{50117.968,8083.543,10.000},
				{50926.322,8083.543,10.000},
				{51734.677,8083.543,10.000},
				{52543.031,8083.543,10.000},
				{53351.385,8083.543,10.000},
				{54159.740,8083.543,10.000},
				{54968.094,8083.543,10.000},
				{55776.448,8083.543,10.000},
				{56584.803,8083.543,10.000},
				{57393.157,8083.543,10.000},
				{58201.511,8083.543,10.000},
				{59009.866,8083.543,10.000},
				{59818.220,8083.543,10.000},
				{60626.574,8083.543,10.000},
				{61434.928,8083.543,10.000},
				{62243.283,8083.543,10.000},
				{63051.637,8083.543,10.000},
				{63859.991,8083.543,10.000},
				{64668.346,8083.543,10.000},
				{65476.700,8083.543,10.000},
				{66285.054,8083.543,10.000},
				{67093.409,8083.543,10.000},
				{67901.763,8083.543,10.000},
				{68710.117,8083.543,10.000},
				{69518.472,8083.543,10.000},
				{70326.826,8083.543,10.000},
				{71135.180,8083.543,10.000},
				{71943.535,8083.543,10.000},
				{72751.889,8083.543,10.000},
				{73560.243,8083.543,10.000},
				{74368.598,8083.543,10.000},
				{75176.952,8083.543,10.000},
				{75985.306,8083.543,10.000},
				{76793.661,8083.543,10.000},
				{77602.015,8083.543,10.000},
				{78410.369,8083.543,10.000},
				{79218.724,8083.543,10.000},
				{80027.078,8083.543,10.000},
				{80835.432,8083.543,10.000},
				{81643.787,8083.543,10.000},
				{82452.141,8083.543,10.000},
				{83260.495,8083.543,10.000},
				{84068.850,8083.543,10.000},
				{84877.204,8083.543,10.000},
				{85685.558,8083.543,10.000},
				{86493.912,8083.543,10.000},
				{87302.267,8083.543,10.000},
				{88110.621,8083.543,10.000},
				{88918.975,8083.543,10.000},
				{89727.330,8083.543,10.000},
				{90535.684,8083.543,10.000},
				{91344.038,8083.543,10.000},
				{92152.393,8083.543,10.000},
				{92960.747,8083.543,10.000},
				{93769.101,8083.543,10.000},
				{94577.456,8083.543,10.000},
				{95385.810,8083.543,10.000},
				{96194.164,8083.543,10.000},
				{97002.519,8083.543,10.000},
				{97810.873,8083.543,10.000},
				{98619.227,8083.543,10.000},
				{99427.582,8083.543,10.000},
				{100235.936,8083.543,10.000},
				{101044.290,8083.543,10.000},
				{101852.645,8083.543,10.000},
				{102660.999,8083.543,10.000},
				{103469.353,8083.543,10.000},
				{104277.708,8083.543,10.000},
				{105086.062,8083.543,10.000},
				{105894.416,8083.543,10.000},
				{106702.771,8083.543,10.000},
				{107511.125,8083.543,10.000},
				{108319.479,8083.543,10.000},
				{109127.536,8080.571,10.000},
				{109934.405,8068.684,10.000},
				{110738.896,8044.909,10.000},
				{111539.820,8009.246,10.000},
				{112335.990,7961.696,10.000},
				{113126.215,7902.258,10.000},
				{113909.309,7830.932,10.000},
				{114684.081,7747.720,10.000},
				{115449.343,7652.619,10.000},
				{116203.906,7545.631,10.000},
				{116946.581,7426.755,10.000},
				{117676.180,7295.992,10.000},
				{118391.515,7153.341,10.000},
				{119091.395,6998.803,10.000},
				{119774.633,6832.377,10.000},
				{120440.039,6654.064,10.000},
				{121086.425,6463.863,10.000},
				{121712.900,6264.746,10.000},
				{122319.166,6062.657,10.000},
				{122905.222,5860.569,10.000},
				{123471.070,5658.480,10.000},
				{124016.710,5456.392,10.000},
				{124542.140,5254.303,10.000},
				{125047.361,5052.215,10.000},
				{125532.374,4850.126,10.000},
				{125997.178,4648.037,10.000},
				{126441.773,4445.949,10.000},
				{126866.159,4243.860,10.000},
				{127270.336,4041.772,10.000},
				{127654.304,3839.683,10.000},
				{128018.064,3637.594,10.000},
				{128361.614,3435.506,10.000},
				{128684.956,3233.417,10.000},
				{128988.089,3031.329,10.000},
				{129271.013,2829.240,10.000},
				{129533.728,2627.152,10.000},
				{129776.234,2425.063,10.000},
				{129998.532,2222.974,10.000},
				{130200.620,2020.886,10.000},
				{130382.500,1818.797,10.000},
				{130544.468,1619.681,10.000},
				{130687.416,1429.480,10.000},
				{130812.533,1251.166,10.000},
				{130921.007,1084.740,10.000},
				{131014.027,930.202,10.000},
				{131092.782,787.551,10.000},
				{131158.461,656.788,10.000},
				{131212.252,537.912,10.000},
				{131255.344,430.924,10.000},
				{131288.927,335.824,10.000},
				{131314.188,252.611,10.000},
				{131332.316,181.285,10.000},
				{131344.501,121.848,10.000},
				{131351.931,74.297,10.000},
				{131355.794,38.635,10.000},
				{131357.280,14.859,10.000},
				{131357.577,2.972,10.000},
				{131357.577,0.000,10.000}
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