package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class CrossTheLine extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (12.00,0.00,0.00)
	
	public CrossTheLine() {
		this(false);
	}
			
    public CrossTheLine(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.601,12.029,10.000},
				{3.007,24.058,10.000},
				{8.420,54.131,10.000},
				{18.044,96.233,10.000},
				{33.080,150.364,10.000},
				{54.732,216.523,10.000},
				{84.204,294.713,10.000},
				{122.697,384.931,10.000},
				{171.414,487.178,10.000},
				{231.560,601.454,10.000},
				{304.336,727.759,10.000},
				{390.945,866.094,10.000},
				{492.591,1016.457,10.000},
				{610.476,1178.850,10.000},
				{745.803,1353.272,10.000},
				{899.174,1533.708,10.000},
				{1070.588,1714.144,10.000},
				{1260.046,1894.580,10.000},
				{1467.548,2075.017,10.000},
				{1693.093,2255.453,10.000},
				{1936.682,2435.889,10.000},
				{2198.315,2616.325,10.000},
				{2477.991,2796.762,10.000},
				{2775.711,2977.198,10.000},
				{3091.474,3157.634,10.000},
				{3425.281,3338.070,10.000},
				{3777.132,3518.507,10.000},
				{4147.026,3698.943,10.000},
				{4534.964,3879.379,10.000},
				{4940.946,4059.815,10.000},
				{5364.971,4240.251,10.000},
				{5807.039,4420.688,10.000},
				{6267.152,4601.124,10.000},
				{6745.308,4781.560,10.000},
				{7241.507,4961.996,10.000},
				{7755.751,5142.433,10.000},
				{8288.038,5322.869,10.000},
				{8838.368,5503.305,10.000},
				{9406.742,5683.741,10.000},
				{9993.160,5864.178,10.000},
				{10597.621,6044.614,10.000},
				{11220.126,6225.050,10.000},
				{11860.675,6405.486,10.000},
				{12519.267,6585.922,10.000},
				{13195.903,6766.359,10.000},
				{13890.583,6946.795,10.000},
				{14603.306,7127.231,10.000},
				{15334.073,7307.667,10.000},
				{16082.883,7488.104,10.000},
				{16849.737,7668.540,10.000},
				{17634.634,7848.976,10.000},
				{18437.576,8029.412,10.000},
				{19258.561,8209.849,10.000},
				{20097.589,8390.285,10.000},
				{20954.661,8570.721,10.000},
				{21829.777,8751.157,10.000},
				{22722.936,8931.594,10.000},
				{23634.139,9112.030,10.000},
				{24563.386,9292.466,10.000},
				{25510.676,9472.902,10.000},
				{26476.010,9653.338,10.000},
				{27459.387,9833.775,10.000},
				{28460.808,10014.211,10.000},
				{29480.273,10194.647,10.000},
				{30517.781,10375.083,10.000},
				{31573.333,10555.520,10.000},
				{32646.929,10735.956,10.000},
				{33738.568,10916.392,10.000},
				{34848.251,11096.828,10.000},
				{35975.978,11277.265,10.000},
				{37121.748,11457.701,10.000},
				{38285.561,11638.137,10.000},
				{39467.419,11818.573,10.000},
				{40667.320,11999.009,10.000},
				{41885.264,12179.446,10.000},
				{43121.252,12359.882,10.000},
				{44375.284,12540.318,10.000},
				{45647.360,12720.754,10.000},
				{46937.479,12901.191,10.000},
				{48245.641,13081.627,10.000},
				{49571.848,13262.063,10.000},
				{50916.098,13442.499,10.000},
				{52278.391,13622.936,10.000},
				{53658.728,13803.372,10.000},
				{55056.508,13977.793,10.000},
				{56470.526,14140.186,10.000},
				{57899.581,14290.550,10.000},
				{59342.470,14428.884,10.000},
				{60797.989,14555.189,10.000},
				{62264.935,14669.466,10.000},
				{63742.106,14771.713,10.000},
				{65228.300,14861.931,10.000},
				{66722.312,14940.120,10.000},
				{68222.940,15006.280,10.000},
				{69728.981,15060.411,10.000},
				{71239.232,15102.513,10.000},
				{72752.490,15132.585,10.000},
				{74267.553,15150.629,10.000},
				{75783.218,15156.644,10.000},
				{77298.882,15156.644,10.000},
				{78814.546,15156.644,10.000},
				{80330.211,15156.644,10.000},
				{81845.875,15156.644,10.000},
				{83361.539,15156.644,10.000},
				{84877.204,15156.644,10.000},
				{86392.868,15156.644,10.000},
				{87908.533,15156.644,10.000},
				{89424.197,15156.644,10.000},
				{90939.861,15156.644,10.000},
				{92455.526,15156.644,10.000},
				{93971.190,15156.644,10.000},
				{95486.854,15156.644,10.000},
				{97002.519,15156.644,10.000},
				{98518.183,15156.644,10.000},
				{100033.847,15156.644,10.000},
				{101549.512,15156.644,10.000},
				{103065.176,15156.644,10.000},
				{104580.840,15156.644,10.000},
				{106096.505,15156.644,10.000},
				{107612.169,15156.644,10.000},
				{109127.833,15156.644,10.000},
				{110643.498,15156.644,10.000},
				{112159.162,15156.644,10.000},
				{113674.827,15156.644,10.000},
				{115190.491,15156.644,10.000},
				{116706.155,15156.644,10.000},
				{118221.820,15156.644,10.000},
				{119737.484,15156.644,10.000},
				{121253.148,15156.644,10.000},
				{122768.813,15156.644,10.000},
				{124284.477,15156.644,10.000},
				{125800.141,15156.644,10.000},
				{127315.806,15156.644,10.000},
				{128831.470,15156.644,10.000},
				{130347.134,15156.644,10.000},
				{131862.799,15156.644,10.000},
				{133378.463,15156.644,10.000},
				{134894.128,15156.644,10.000},
				{136409.792,15156.644,10.000},
				{137925.456,15156.644,10.000},
				{139441.121,15156.644,10.000},
				{140956.785,15156.644,10.000},
				{142472.449,15156.644,10.000},
				{143988.114,15156.644,10.000},
				{145503.778,15156.644,10.000},
				{147019.442,15156.644,10.000},
				{148535.107,15156.644,10.000},
				{150050.771,15156.644,10.000},
				{151566.435,15156.644,10.000},
				{153082.100,15156.644,10.000},
				{154597.764,15156.644,10.000},
				{156113.428,15156.644,10.000},
				{157629.093,15156.644,10.000},
				{159144.757,15156.644,10.000},
				{160660.422,15156.644,10.000},
				{162176.086,15156.644,10.000},
				{163691.750,15156.644,10.000},
				{165207.415,15156.644,10.000},
				{166723.079,15156.644,10.000},
				{168238.743,15156.644,10.000},
				{169753.806,15150.629,10.000},
				{171267.065,15132.585,10.000},
				{172777.316,15102.513,10.000},
				{174283.357,15060.411,10.000},
				{175783.985,15006.280,10.000},
				{177277.997,14940.120,10.000},
				{178764.190,14861.931,10.000},
				{180241.361,14771.713,10.000},
				{181708.308,14669.466,10.000},
				{183163.827,14555.189,10.000},
				{184606.715,14428.884,10.000},
				{186035.770,14290.550,10.000},
				{187449.789,14140.186,10.000},
				{188847.568,13977.793,10.000},
				{190227.906,13803.372,10.000},
				{191590.199,13622.936,10.000},
				{192934.449,13442.499,10.000},
				{194260.655,13262.063,10.000},
				{195568.818,13081.627,10.000},
				{196858.937,12901.191,10.000},
				{198131.013,12720.754,10.000},
				{199385.044,12540.318,10.000},
				{200621.033,12359.882,10.000},
				{201838.977,12179.446,10.000},
				{203038.878,11999.009,10.000},
				{204220.735,11818.573,10.000},
				{205384.549,11638.137,10.000},
				{206530.319,11457.701,10.000},
				{207658.046,11277.265,10.000},
				{208767.728,11096.828,10.000},
				{209859.368,10916.392,10.000},
				{210932.963,10735.956,10.000},
				{211988.515,10555.520,10.000},
				{213026.024,10375.083,10.000},
				{214045.488,10194.647,10.000},
				{215046.909,10014.211,10.000},
				{216030.287,9833.775,10.000},
				{216995.621,9653.338,10.000},
				{217942.911,9472.902,10.000},
				{218872.157,9292.466,10.000},
				{219783.360,9112.030,10.000},
				{220676.520,8931.594,10.000},
				{221551.635,8751.157,10.000},
				{222408.708,8570.721,10.000},
				{223247.736,8390.285,10.000},
				{224068.721,8209.849,10.000},
				{224871.662,8029.412,10.000},
				{225656.560,7848.976,10.000},
				{226423.414,7668.540,10.000},
				{227172.224,7488.104,10.000},
				{227902.991,7307.667,10.000},
				{228615.714,7127.231,10.000},
				{229310.394,6946.795,10.000},
				{229987.029,6766.359,10.000},
				{230645.622,6585.922,10.000},
				{231286.170,6405.486,10.000},
				{231908.675,6225.050,10.000},
				{232513.137,6044.614,10.000},
				{233099.554,5864.178,10.000},
				{233667.929,5683.741,10.000},
				{234218.259,5503.305,10.000},
				{234750.546,5322.869,10.000},
				{235264.789,5142.433,10.000},
				{235760.989,4961.996,10.000},
				{236239.145,4781.560,10.000},
				{236699.257,4601.124,10.000},
				{237141.326,4420.688,10.000},
				{237565.351,4240.251,10.000},
				{237971.333,4059.815,10.000},
				{238359.271,3879.379,10.000},
				{238729.165,3698.943,10.000},
				{239081.015,3518.507,10.000},
				{239414.823,3338.070,10.000},
				{239730.586,3157.634,10.000},
				{240028.306,2977.198,10.000},
				{240307.982,2796.762,10.000},
				{240569.614,2616.325,10.000},
				{240813.203,2435.889,10.000},
				{241038.749,2255.453,10.000},
				{241246.250,2075.017,10.000},
				{241435.708,1894.580,10.000},
				{241607.123,1714.144,10.000},
				{241760.494,1533.708,10.000},
				{241895.821,1353.272,10.000},
				{242013.706,1178.850,10.000},
				{242115.351,1016.457,10.000},
				{242201.961,866.094,10.000},
				{242274.737,727.759,10.000},
				{242334.882,601.454,10.000},
				{242383.600,487.178,10.000},
				{242422.093,384.931,10.000},
				{242451.564,294.713,10.000},
				{242473.217,216.523,10.000},
				{242488.253,150.364,10.000},
				{242497.876,96.233,10.000},
				{242503.289,54.131,10.000},
				{242505.695,24.058,10.000},
				{242506.297,6.015,10.000},
				{242506.297,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.601,12.029,10.000},
				{3.007,24.058,10.000},
				{8.420,54.131,10.000},
				{18.044,96.233,10.000},
				{33.080,150.364,10.000},
				{54.732,216.523,10.000},
				{84.204,294.713,10.000},
				{122.697,384.931,10.000},
				{171.414,487.178,10.000},
				{231.560,601.454,10.000},
				{304.336,727.759,10.000},
				{390.945,866.094,10.000},
				{492.591,1016.457,10.000},
				{610.476,1178.850,10.000},
				{745.803,1353.272,10.000},
				{899.174,1533.708,10.000},
				{1070.588,1714.144,10.000},
				{1260.046,1894.580,10.000},
				{1467.548,2075.017,10.000},
				{1693.093,2255.453,10.000},
				{1936.682,2435.889,10.000},
				{2198.315,2616.325,10.000},
				{2477.991,2796.762,10.000},
				{2775.711,2977.198,10.000},
				{3091.474,3157.634,10.000},
				{3425.281,3338.070,10.000},
				{3777.132,3518.507,10.000},
				{4147.026,3698.943,10.000},
				{4534.964,3879.379,10.000},
				{4940.946,4059.815,10.000},
				{5364.971,4240.251,10.000},
				{5807.039,4420.688,10.000},
				{6267.152,4601.124,10.000},
				{6745.308,4781.560,10.000},
				{7241.507,4961.996,10.000},
				{7755.751,5142.433,10.000},
				{8288.038,5322.869,10.000},
				{8838.368,5503.305,10.000},
				{9406.742,5683.741,10.000},
				{9993.160,5864.178,10.000},
				{10597.621,6044.614,10.000},
				{11220.126,6225.050,10.000},
				{11860.675,6405.486,10.000},
				{12519.267,6585.922,10.000},
				{13195.903,6766.359,10.000},
				{13890.583,6946.795,10.000},
				{14603.306,7127.231,10.000},
				{15334.073,7307.667,10.000},
				{16082.883,7488.104,10.000},
				{16849.737,7668.540,10.000},
				{17634.634,7848.976,10.000},
				{18437.576,8029.412,10.000},
				{19258.561,8209.849,10.000},
				{20097.589,8390.285,10.000},
				{20954.661,8570.721,10.000},
				{21829.777,8751.157,10.000},
				{22722.936,8931.594,10.000},
				{23634.139,9112.030,10.000},
				{24563.386,9292.466,10.000},
				{25510.676,9472.902,10.000},
				{26476.010,9653.338,10.000},
				{27459.387,9833.775,10.000},
				{28460.808,10014.211,10.000},
				{29480.273,10194.647,10.000},
				{30517.781,10375.083,10.000},
				{31573.333,10555.520,10.000},
				{32646.929,10735.956,10.000},
				{33738.568,10916.392,10.000},
				{34848.251,11096.828,10.000},
				{35975.978,11277.265,10.000},
				{37121.748,11457.701,10.000},
				{38285.561,11638.137,10.000},
				{39467.419,11818.573,10.000},
				{40667.320,11999.009,10.000},
				{41885.264,12179.446,10.000},
				{43121.252,12359.882,10.000},
				{44375.284,12540.318,10.000},
				{45647.360,12720.754,10.000},
				{46937.479,12901.191,10.000},
				{48245.641,13081.627,10.000},
				{49571.848,13262.063,10.000},
				{50916.098,13442.499,10.000},
				{52278.391,13622.936,10.000},
				{53658.728,13803.372,10.000},
				{55056.508,13977.793,10.000},
				{56470.526,14140.186,10.000},
				{57899.581,14290.550,10.000},
				{59342.470,14428.884,10.000},
				{60797.989,14555.189,10.000},
				{62264.935,14669.466,10.000},
				{63742.106,14771.713,10.000},
				{65228.300,14861.931,10.000},
				{66722.312,14940.120,10.000},
				{68222.940,15006.280,10.000},
				{69728.981,15060.411,10.000},
				{71239.232,15102.513,10.000},
				{72752.490,15132.585,10.000},
				{74267.553,15150.629,10.000},
				{75783.218,15156.644,10.000},
				{77298.882,15156.644,10.000},
				{78814.546,15156.644,10.000},
				{80330.211,15156.644,10.000},
				{81845.875,15156.644,10.000},
				{83361.539,15156.644,10.000},
				{84877.204,15156.644,10.000},
				{86392.868,15156.644,10.000},
				{87908.533,15156.644,10.000},
				{89424.197,15156.644,10.000},
				{90939.861,15156.644,10.000},
				{92455.526,15156.644,10.000},
				{93971.190,15156.644,10.000},
				{95486.854,15156.644,10.000},
				{97002.519,15156.644,10.000},
				{98518.183,15156.644,10.000},
				{100033.847,15156.644,10.000},
				{101549.512,15156.644,10.000},
				{103065.176,15156.644,10.000},
				{104580.840,15156.644,10.000},
				{106096.505,15156.644,10.000},
				{107612.169,15156.644,10.000},
				{109127.833,15156.644,10.000},
				{110643.498,15156.644,10.000},
				{112159.162,15156.644,10.000},
				{113674.827,15156.644,10.000},
				{115190.491,15156.644,10.000},
				{116706.155,15156.644,10.000},
				{118221.820,15156.644,10.000},
				{119737.484,15156.644,10.000},
				{121253.148,15156.644,10.000},
				{122768.813,15156.644,10.000},
				{124284.477,15156.644,10.000},
				{125800.141,15156.644,10.000},
				{127315.806,15156.644,10.000},
				{128831.470,15156.644,10.000},
				{130347.134,15156.644,10.000},
				{131862.799,15156.644,10.000},
				{133378.463,15156.644,10.000},
				{134894.128,15156.644,10.000},
				{136409.792,15156.644,10.000},
				{137925.456,15156.644,10.000},
				{139441.121,15156.644,10.000},
				{140956.785,15156.644,10.000},
				{142472.449,15156.644,10.000},
				{143988.114,15156.644,10.000},
				{145503.778,15156.644,10.000},
				{147019.442,15156.644,10.000},
				{148535.107,15156.644,10.000},
				{150050.771,15156.644,10.000},
				{151566.435,15156.644,10.000},
				{153082.100,15156.644,10.000},
				{154597.764,15156.644,10.000},
				{156113.428,15156.644,10.000},
				{157629.093,15156.644,10.000},
				{159144.757,15156.644,10.000},
				{160660.422,15156.644,10.000},
				{162176.086,15156.644,10.000},
				{163691.750,15156.644,10.000},
				{165207.415,15156.644,10.000},
				{166723.079,15156.644,10.000},
				{168238.743,15156.644,10.000},
				{169753.806,15150.629,10.000},
				{171267.065,15132.585,10.000},
				{172777.316,15102.513,10.000},
				{174283.357,15060.411,10.000},
				{175783.985,15006.280,10.000},
				{177277.997,14940.120,10.000},
				{178764.190,14861.931,10.000},
				{180241.361,14771.713,10.000},
				{181708.308,14669.466,10.000},
				{183163.827,14555.189,10.000},
				{184606.715,14428.884,10.000},
				{186035.770,14290.550,10.000},
				{187449.789,14140.186,10.000},
				{188847.568,13977.793,10.000},
				{190227.906,13803.372,10.000},
				{191590.199,13622.936,10.000},
				{192934.449,13442.499,10.000},
				{194260.655,13262.063,10.000},
				{195568.818,13081.627,10.000},
				{196858.937,12901.191,10.000},
				{198131.013,12720.754,10.000},
				{199385.044,12540.318,10.000},
				{200621.033,12359.882,10.000},
				{201838.977,12179.446,10.000},
				{203038.878,11999.009,10.000},
				{204220.735,11818.573,10.000},
				{205384.549,11638.137,10.000},
				{206530.319,11457.701,10.000},
				{207658.046,11277.265,10.000},
				{208767.728,11096.828,10.000},
				{209859.368,10916.392,10.000},
				{210932.963,10735.956,10.000},
				{211988.515,10555.520,10.000},
				{213026.024,10375.083,10.000},
				{214045.488,10194.647,10.000},
				{215046.909,10014.211,10.000},
				{216030.287,9833.775,10.000},
				{216995.621,9653.338,10.000},
				{217942.911,9472.902,10.000},
				{218872.157,9292.466,10.000},
				{219783.360,9112.030,10.000},
				{220676.520,8931.594,10.000},
				{221551.635,8751.157,10.000},
				{222408.708,8570.721,10.000},
				{223247.736,8390.285,10.000},
				{224068.721,8209.849,10.000},
				{224871.662,8029.412,10.000},
				{225656.560,7848.976,10.000},
				{226423.414,7668.540,10.000},
				{227172.224,7488.104,10.000},
				{227902.991,7307.667,10.000},
				{228615.714,7127.231,10.000},
				{229310.394,6946.795,10.000},
				{229987.029,6766.359,10.000},
				{230645.622,6585.922,10.000},
				{231286.170,6405.486,10.000},
				{231908.675,6225.050,10.000},
				{232513.137,6044.614,10.000},
				{233099.554,5864.178,10.000},
				{233667.929,5683.741,10.000},
				{234218.259,5503.305,10.000},
				{234750.546,5322.869,10.000},
				{235264.789,5142.433,10.000},
				{235760.989,4961.996,10.000},
				{236239.145,4781.560,10.000},
				{236699.257,4601.124,10.000},
				{237141.326,4420.688,10.000},
				{237565.351,4240.251,10.000},
				{237971.333,4059.815,10.000},
				{238359.271,3879.379,10.000},
				{238729.165,3698.943,10.000},
				{239081.015,3518.507,10.000},
				{239414.823,3338.070,10.000},
				{239730.586,3157.634,10.000},
				{240028.306,2977.198,10.000},
				{240307.982,2796.762,10.000},
				{240569.614,2616.325,10.000},
				{240813.203,2435.889,10.000},
				{241038.749,2255.453,10.000},
				{241246.250,2075.017,10.000},
				{241435.708,1894.580,10.000},
				{241607.123,1714.144,10.000},
				{241760.494,1533.708,10.000},
				{241895.821,1353.272,10.000},
				{242013.706,1178.850,10.000},
				{242115.351,1016.457,10.000},
				{242201.961,866.094,10.000},
				{242274.737,727.759,10.000},
				{242334.882,601.454,10.000},
				{242383.600,487.178,10.000},
				{242422.093,384.931,10.000},
				{242451.564,294.713,10.000},
				{242473.217,216.523,10.000},
				{242488.253,150.364,10.000},
				{242497.876,96.233,10.000},
				{242503.289,54.131,10.000},
				{242505.695,24.058,10.000},
				{242506.297,6.015,10.000},
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