package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class LeftEasySwitch extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (12.00,0.00,0.00)
	
	public LeftEasySwitch() {
		this(false);
	}
			
    public LeftEasySwitch(boolean flipped) {
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
				{109127.833,8083.543,10.000},
				{109936.188,8083.543,10.000},
				{110744.542,8083.543,10.000},
				{111552.896,8083.543,10.000},
				{112361.251,8083.543,10.000},
				{113169.605,8083.543,10.000},
				{113977.959,8083.543,10.000},
				{114786.314,8083.543,10.000},
				{115594.668,8083.543,10.000},
				{116403.022,8083.543,10.000},
				{117211.377,8083.543,10.000},
				{118019.731,8083.543,10.000},
				{118828.085,8083.543,10.000},
				{119636.440,8083.543,10.000},
				{120444.794,8083.543,10.000},
				{121253.148,8083.543,10.000},
				{122061.503,8083.543,10.000},
				{122869.857,8083.543,10.000},
				{123678.211,8083.543,10.000},
				{124486.566,8083.543,10.000},
				{125294.920,8083.543,10.000},
				{126103.274,8083.543,10.000},
				{126911.629,8083.543,10.000},
				{127719.983,8083.543,10.000},
				{128528.337,8083.543,10.000},
				{129336.692,8083.543,10.000},
				{130145.046,8083.543,10.000},
				{130953.400,8083.543,10.000},
				{131761.755,8083.543,10.000},
				{132570.109,8083.543,10.000},
				{133378.463,8083.543,10.000},
				{134186.817,8083.543,10.000},
				{134995.172,8083.543,10.000},
				{135803.526,8083.543,10.000},
				{136611.880,8083.543,10.000},
				{137420.235,8083.543,10.000},
				{138228.589,8083.543,10.000},
				{139036.943,8083.543,10.000},
				{139845.298,8083.543,10.000},
				{140653.652,8083.543,10.000},
				{141462.006,8083.543,10.000},
				{142270.361,8083.543,10.000},
				{143078.715,8083.543,10.000},
				{143887.069,8083.543,10.000},
				{144695.424,8083.543,10.000},
				{145503.778,8083.543,10.000},
				{146312.132,8083.543,10.000},
				{147120.487,8083.543,10.000},
				{147928.841,8083.543,10.000},
				{148737.195,8083.543,10.000},
				{149545.550,8083.543,10.000},
				{150353.904,8083.543,10.000},
				{151162.258,8083.543,10.000},
				{151970.613,8083.543,10.000},
				{152778.967,8083.543,10.000},
				{153587.321,8083.543,10.000},
				{154395.676,8083.543,10.000},
				{155204.030,8083.543,10.000},
				{156012.384,8083.543,10.000},
				{156820.738,8083.543,10.000},
				{157629.093,8083.543,10.000},
				{158437.447,8083.543,10.000},
				{159245.801,8083.543,10.000},
				{160054.156,8083.543,10.000},
				{160862.510,8083.543,10.000},
				{161670.864,8083.543,10.000},
				{162479.219,8083.543,10.000},
				{163287.573,8083.543,10.000},
				{164095.927,8083.543,10.000},
				{164904.282,8083.543,10.000},
				{165712.636,8083.543,10.000},
				{166520.990,8083.543,10.000},
				{167329.345,8083.543,10.000},
				{168137.699,8083.543,10.000},
				{168946.053,8083.543,10.000},
				{169754.408,8083.543,10.000},
				{170562.762,8083.543,10.000},
				{171371.116,8083.543,10.000},
				{172179.471,8083.543,10.000},
				{172987.825,8083.543,10.000},
				{173796.179,8083.543,10.000},
				{174604.534,8083.543,10.000},
				{175412.888,8083.543,10.000},
				{176221.242,8083.543,10.000},
				{177029.597,8083.543,10.000},
				{177837.951,8083.543,10.000},
				{178646.305,8083.543,10.000},
				{179454.660,8083.543,10.000},
				{180263.014,8083.543,10.000},
				{181071.368,8083.543,10.000},
				{181879.722,8083.543,10.000},
				{182688.077,8083.543,10.000},
				{183496.431,8083.543,10.000},
				{184304.785,8083.543,10.000},
				{185113.140,8083.543,10.000},
				{185921.494,8083.543,10.000},
				{186729.848,8083.543,10.000},
				{187538.203,8083.543,10.000},
				{188346.557,8083.543,10.000},
				{189154.911,8083.543,10.000},
				{189963.266,8083.543,10.000},
				{190771.620,8083.543,10.000},
				{191579.974,8083.543,10.000},
				{192388.329,8083.543,10.000},
				{193196.683,8083.543,10.000},
				{194005.037,8083.543,10.000},
				{194813.392,8083.543,10.000},
				{195621.746,8083.543,10.000},
				{196430.100,8083.543,10.000},
				{197238.455,8083.543,10.000},
				{198046.809,8083.543,10.000},
				{198855.163,8083.543,10.000},
				{199663.518,8083.543,10.000},
				{200471.872,8083.543,10.000},
				{201280.226,8083.543,10.000},
				{202088.581,8083.543,10.000},
				{202896.935,8083.543,10.000},
				{203705.289,8083.543,10.000},
				{204513.644,8083.543,10.000},
				{205321.998,8083.543,10.000},
				{206130.352,8083.543,10.000},
				{206938.706,8083.543,10.000},
				{207747.061,8083.543,10.000},
				{208555.415,8083.543,10.000},
				{209363.769,8083.543,10.000},
				{210172.124,8083.543,10.000},
				{210980.478,8083.543,10.000},
				{211788.832,8083.543,10.000},
				{212597.187,8083.543,10.000},
				{213405.541,8083.543,10.000},
				{214213.895,8083.543,10.000},
				{215022.250,8083.543,10.000},
				{215830.604,8083.543,10.000},
				{216638.958,8083.543,10.000},
				{217447.313,8083.543,10.000},
				{218255.667,8083.543,10.000},
				{219064.021,8083.543,10.000},
				{219872.376,8083.543,10.000},
				{220680.136,8077.599,10.000},
				{221486.112,8059.768,10.000},
				{222289.117,8030.049,10.000},
				{223087.962,7988.443,10.000},
				{223881.456,7934.949,10.000},
				{224668.413,7869.567,10.000},
				{225447.643,7792.298,10.000},
				{226217.957,7703.141,10.000},
				{226978.167,7602.097,10.000},
				{227727.083,7489.165,10.000},
				{228463.518,7364.346,10.000},
				{229186.282,7227.639,10.000},
				{229894.186,7079.044,10.000},
				{230586.042,6918.562,10.000},
				{231260.662,6746.192,10.000},
				{231916.855,6561.935,10.000},
				{232553.434,6365.790,10.000},
				{233169.804,6163.702,10.000},
				{233765.966,5961.613,10.000},
				{234341.918,5759.525,10.000},
				{234897.662,5557.436,10.000},
				{235433.196,5355.347,10.000},
				{235948.522,5153.259,10.000},
				{236443.639,4951.170,10.000},
				{236918.547,4749.082,10.000},
				{237373.247,4546.993,10.000},
				{237807.737,4344.904,10.000},
				{238222.019,4142.816,10.000},
				{238616.091,3940.727,10.000},
				{238989.955,3738.639,10.000},
				{239343.610,3536.550,10.000},
				{239677.057,3334.462,10.000},
				{239990.294,3132.373,10.000},
				{240283.322,2930.284,10.000},
				{240556.142,2728.196,10.000},
				{240808.753,2526.107,10.000},
				{241041.154,2324.019,10.000},
				{241253.347,2121.930,10.000},
				{241445.332,1919.842,10.000},
				{241617.107,1717.753,10.000},
				{241769.268,1521.608,10.000},
				{241903.003,1337.351,10.000},
				{242019.501,1164.981,10.000},
				{242119.951,1004.499,10.000},
				{242205.541,855.905,10.000},
				{242277.461,719.198,10.000},
				{242336.899,594.378,10.000},
				{242385.044,481.446,10.000},
				{242423.084,380.402,10.000},
				{242452.208,291.245,10.000},
				{242473.606,213.976,10.000},
				{242488.465,148.595,10.000},
				{242497.975,95.101,10.000},
				{242503.325,53.494,10.000},
				{242505.702,23.775,10.000},
				{242506.297,5.944,10.000},
				{242506.297,0.000,10.000}
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
				{109127.833,8083.543,10.000},
				{109936.188,8083.543,10.000},
				{110744.542,8083.543,10.000},
				{111552.896,8083.543,10.000},
				{112361.251,8083.543,10.000},
				{113169.605,8083.543,10.000},
				{113977.959,8083.543,10.000},
				{114786.314,8083.543,10.000},
				{115594.668,8083.543,10.000},
				{116403.022,8083.543,10.000},
				{117211.377,8083.543,10.000},
				{118019.731,8083.543,10.000},
				{118828.085,8083.543,10.000},
				{119636.440,8083.543,10.000},
				{120444.794,8083.543,10.000},
				{121253.148,8083.543,10.000},
				{122061.503,8083.543,10.000},
				{122869.857,8083.543,10.000},
				{123678.211,8083.543,10.000},
				{124486.566,8083.543,10.000},
				{125294.920,8083.543,10.000},
				{126103.274,8083.543,10.000},
				{126911.629,8083.543,10.000},
				{127719.983,8083.543,10.000},
				{128528.337,8083.543,10.000},
				{129336.692,8083.543,10.000},
				{130145.046,8083.543,10.000},
				{130953.400,8083.543,10.000},
				{131761.755,8083.543,10.000},
				{132570.109,8083.543,10.000},
				{133378.463,8083.543,10.000},
				{134186.817,8083.543,10.000},
				{134995.172,8083.543,10.000},
				{135803.526,8083.543,10.000},
				{136611.880,8083.543,10.000},
				{137420.235,8083.543,10.000},
				{138228.589,8083.543,10.000},
				{139036.943,8083.543,10.000},
				{139845.298,8083.543,10.000},
				{140653.652,8083.543,10.000},
				{141462.006,8083.543,10.000},
				{142270.361,8083.543,10.000},
				{143078.715,8083.543,10.000},
				{143887.069,8083.543,10.000},
				{144695.424,8083.543,10.000},
				{145503.778,8083.543,10.000},
				{146312.132,8083.543,10.000},
				{147120.487,8083.543,10.000},
				{147928.841,8083.543,10.000},
				{148737.195,8083.543,10.000},
				{149545.550,8083.543,10.000},
				{150353.904,8083.543,10.000},
				{151162.258,8083.543,10.000},
				{151970.613,8083.543,10.000},
				{152778.967,8083.543,10.000},
				{153587.321,8083.543,10.000},
				{154395.676,8083.543,10.000},
				{155204.030,8083.543,10.000},
				{156012.384,8083.543,10.000},
				{156820.738,8083.543,10.000},
				{157629.093,8083.543,10.000},
				{158437.447,8083.543,10.000},
				{159245.801,8083.543,10.000},
				{160054.156,8083.543,10.000},
				{160862.510,8083.543,10.000},
				{161670.864,8083.543,10.000},
				{162479.219,8083.543,10.000},
				{163287.573,8083.543,10.000},
				{164095.927,8083.543,10.000},
				{164904.282,8083.543,10.000},
				{165712.636,8083.543,10.000},
				{166520.990,8083.543,10.000},
				{167329.345,8083.543,10.000},
				{168137.699,8083.543,10.000},
				{168946.053,8083.543,10.000},
				{169754.408,8083.543,10.000},
				{170562.762,8083.543,10.000},
				{171371.116,8083.543,10.000},
				{172179.471,8083.543,10.000},
				{172987.825,8083.543,10.000},
				{173796.179,8083.543,10.000},
				{174604.534,8083.543,10.000},
				{175412.888,8083.543,10.000},
				{176221.242,8083.543,10.000},
				{177029.597,8083.543,10.000},
				{177837.951,8083.543,10.000},
				{178646.305,8083.543,10.000},
				{179454.660,8083.543,10.000},
				{180263.014,8083.543,10.000},
				{181071.368,8083.543,10.000},
				{181879.722,8083.543,10.000},
				{182688.077,8083.543,10.000},
				{183496.431,8083.543,10.000},
				{184304.785,8083.543,10.000},
				{185113.140,8083.543,10.000},
				{185921.494,8083.543,10.000},
				{186729.848,8083.543,10.000},
				{187538.203,8083.543,10.000},
				{188346.557,8083.543,10.000},
				{189154.911,8083.543,10.000},
				{189963.266,8083.543,10.000},
				{190771.620,8083.543,10.000},
				{191579.974,8083.543,10.000},
				{192388.329,8083.543,10.000},
				{193196.683,8083.543,10.000},
				{194005.037,8083.543,10.000},
				{194813.392,8083.543,10.000},
				{195621.746,8083.543,10.000},
				{196430.100,8083.543,10.000},
				{197238.455,8083.543,10.000},
				{198046.809,8083.543,10.000},
				{198855.163,8083.543,10.000},
				{199663.518,8083.543,10.000},
				{200471.872,8083.543,10.000},
				{201280.226,8083.543,10.000},
				{202088.581,8083.543,10.000},
				{202896.935,8083.543,10.000},
				{203705.289,8083.543,10.000},
				{204513.644,8083.543,10.000},
				{205321.998,8083.543,10.000},
				{206130.352,8083.543,10.000},
				{206938.706,8083.543,10.000},
				{207747.061,8083.543,10.000},
				{208555.415,8083.543,10.000},
				{209363.769,8083.543,10.000},
				{210172.124,8083.543,10.000},
				{210980.478,8083.543,10.000},
				{211788.832,8083.543,10.000},
				{212597.187,8083.543,10.000},
				{213405.541,8083.543,10.000},
				{214213.895,8083.543,10.000},
				{215022.250,8083.543,10.000},
				{215830.604,8083.543,10.000},
				{216638.958,8083.543,10.000},
				{217447.313,8083.543,10.000},
				{218255.667,8083.543,10.000},
				{219064.021,8083.543,10.000},
				{219872.376,8083.543,10.000},
				{220680.136,8077.599,10.000},
				{221486.112,8059.768,10.000},
				{222289.117,8030.049,10.000},
				{223087.962,7988.443,10.000},
				{223881.456,7934.949,10.000},
				{224668.413,7869.567,10.000},
				{225447.643,7792.298,10.000},
				{226217.957,7703.141,10.000},
				{226978.167,7602.097,10.000},
				{227727.083,7489.165,10.000},
				{228463.518,7364.346,10.000},
				{229186.282,7227.639,10.000},
				{229894.186,7079.044,10.000},
				{230586.042,6918.562,10.000},
				{231260.662,6746.192,10.000},
				{231916.855,6561.935,10.000},
				{232553.434,6365.790,10.000},
				{233169.804,6163.702,10.000},
				{233765.966,5961.613,10.000},
				{234341.918,5759.525,10.000},
				{234897.662,5557.436,10.000},
				{235433.196,5355.347,10.000},
				{235948.522,5153.259,10.000},
				{236443.639,4951.170,10.000},
				{236918.547,4749.082,10.000},
				{237373.247,4546.993,10.000},
				{237807.737,4344.904,10.000},
				{238222.019,4142.816,10.000},
				{238616.091,3940.727,10.000},
				{238989.955,3738.639,10.000},
				{239343.610,3536.550,10.000},
				{239677.057,3334.462,10.000},
				{239990.294,3132.373,10.000},
				{240283.322,2930.284,10.000},
				{240556.142,2728.196,10.000},
				{240808.753,2526.107,10.000},
				{241041.154,2324.019,10.000},
				{241253.347,2121.930,10.000},
				{241445.332,1919.842,10.000},
				{241617.107,1717.753,10.000},
				{241769.268,1521.608,10.000},
				{241903.003,1337.351,10.000},
				{242019.501,1164.981,10.000},
				{242119.951,1004.499,10.000},
				{242205.541,855.905,10.000},
				{242277.461,719.198,10.000},
				{242336.899,594.378,10.000},
				{242385.044,481.446,10.000},
				{242423.084,380.402,10.000},
				{242452.208,291.245,10.000},
				{242473.606,213.976,10.000},
				{242488.465,148.595,10.000},
				{242497.975,95.101,10.000},
				{242503.325,53.494,10.000},
				{242505.702,23.775,10.000},
				{242506.297,5.944,10.000},
				{242506.297,0.000,10.000}
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