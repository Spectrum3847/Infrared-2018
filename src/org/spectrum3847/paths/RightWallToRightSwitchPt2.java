package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class RightWallToRightSwitchPt2 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (2.00,-1.00,-30.00)
	
	public RightWallToRightSwitchPt2() {
		this(false);
	}
			
    public RightWallToRightSwitchPt2(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{0.594,11.888,10.000},
				{2.972,23.780,10.000},
				{8.325,53.526,10.000},
				{17.848,95.231,10.000},
				{32.747,148.988,10.000},
				{54.242,214.948,10.000},
				{83.575,293.335,10.000},
				{122.021,384.460,10.000},
				{170.894,488.730,10.000},
				{231.561,606.666,10.000},
				{305.451,738.906,10.000},
				{394.073,886.217,10.000},
				{499.023,1049.502,10.000},
				{622.003,1229.804,10.000},
				{764.834,1428.308,10.000},
				{929.469,1646.344,10.000},
				{1118.007,1885.383,10.000},
				{1332.042,2140.357,10.000},
				{1572.617,2405.748,10.000},
				{1840.853,2682.361,10.000},
				{2137.948,2970.941,10.000},
				{2465.165,3272.174,10.000},
				{2823.834,3586.692,10.000},
				{3215.342,3915.074,10.000},
				{3641.126,4257.845,10.000},
				{4102.674,4615.478,10.000},
				{4601.512,4988.383,10.000},
				{5139.202,5376.896,10.000},
				{5717.328,5781.259,10.000},
				{6337.487,6201.593,10.000},
				{7001.272,6637.854,10.000},
				{7710.250,7089.780,10.000},
				{8465.933,7556.827,10.000},
				{9269.741,8038.077,10.000},
				{10122.955,8532.143,10.000},
				{11026.660,9037.055,10.000},
				{11981.674,9550.135,10.000},
				{12988.462,10067.879,10.000},
				{14047.046,10585.847,10.000},
				{15156.905,11098.589,10.000},
				{16315.813,11589.077,10.000},
				{17519.698,12038.849,10.000},
				{18763.636,12439.380,10.000},
				{20041.880,12782.438,10.000},
				{21347.943,13060.631,10.000},
				{22674.740,13267.975,10.000},
				{24014.780,13400.395,10.000},
				{25360.389,13456.087,10.000},
				{26703.956,13435.671,10.000},
				{28038.167,13342.116,10.000},
				{29356.212,13180.450,10.000},
				{30651.942,12957.301,10.000},
				{31919.978,12680.354,10.000},
				{33155.757,12357.792,10.000},
				{34355.538,11997.812,10.000},
				{35516.360,11608.224,10.000},
				{36635.980,11196.197,10.000},
				{37713.175,10771.952,10.000},
				{38747.219,10340.435,10.000},
				{39737.447,9902.281,10.000},
				{40683.605,9461.579,10.000},
				{41585.788,9021.835,10.000},
				{42444.396,8586.079,10.000},
				{43260.094,8156.978,10.000},
				{44033.786,7736.924,10.000},
				{44766.596,7328.096,10.000},
				{45459.846,6932.498,10.000},
				{46115.043,6551.968,10.000},
				{46733.858,6188.157,10.000},
				{47318.107,5842.486,10.000},
				{47869.716,5516.087,10.000},
				{48390.689,5209.735,10.000},
				{48883.066,4923.770,10.000},
				{49348.870,4658.039,10.000},
				{49790.264,4413.941,10.000},
				{50209.680,4194.160,10.000},
				{50609.544,3998.642,10.000},
				{50992.047,3825.029,10.000},
				{51359.131,3670.841,10.000},
				{51712.482,3533.506,10.000},
				{52053.523,3410.410,10.000},
				{52383.417,3298.943,10.000},
				{52703.071,3196.537,10.000},
				{53013.142,3100.717,10.000},
				{53314.055,3009.128,10.000},
				{53606.013,2919.576,10.000},
				{53889.018,2830.047,10.000},
				{54162.890,2738.729,10.000},
				{54427.293,2644.023,10.000},
				{54681.748,2544.555,10.000},
				{54925.666,2439.179,10.000},
				{55158.363,2326.973,10.000},
				{55379.088,2207.243,10.000},
				{55587.039,2079.511,10.000},
				{55781.390,1943.511,10.000},
				{55961.308,1799.176,10.000},
				{56125.970,1646.628,10.000},
				{56274.865,1488.949,10.000},
				{56408.097,1332.322,10.000},
				{56526.148,1180.503,10.000},
				{56629.604,1034.566,10.000},
				{56719.156,895.521,10.000},
				{56795.586,764.293,10.000},
				{56859.757,641.713,10.000},
				{56912.608,528.508,10.000},
				{56955.138,425.300,10.000},
				{56988.398,332.606,10.000},
				{57013.483,250.845,10.000},
				{57031.517,180.342,10.000},
				{57043.651,121.340,10.000},
				{57051.052,74.010,10.000},
				{57054.898,38.463,10.000},
				{57056.375,14.763,10.000},
				{57056.669,2.940,10.000},
				{57056.669,0.000,10.000}
		};
		
		double[][] rightPoints = {
				{0.594,11.888,10.000},
				{2.971,23.771,10.000},
				{8.318,53.462,10.000},
				{17.815,94.970,10.000},
				{32.635,148.201,10.000},
				{53.935,213.005,10.000},
				{82.851,289.156,10.000},
				{120.485,376.345,10.000},
				{167.902,474.162,10.000},
				{226.111,582.090,10.000},
				{296.060,699.490,10.000},
				{378.619,825.593,10.000},
				{474.568,959.496,10.000},
				{584.584,1100.159,10.000},
				{709.224,1246.394,10.000},
				{848.911,1396.873,10.000},
				{1003.923,1550.123,10.000},
				{1173.856,1699.326,10.000},
				{1357.667,1838.112,10.000},
				{1554.235,1965.676,10.000},
				{1762.362,2081.272,10.000},
				{1980.783,2184.216,10.000},
				{2208.171,2273.874,10.000},
				{2443.138,2349.668,10.000},
				{2684.245,2411.072,10.000},
				{2930.006,2457.614,10.000},
				{3178.895,2488.883,10.000},
				{3429.349,2504.543,10.000},
				{3679.784,2504.350,10.000},
				{3928.602,2488.186,10.000},
				{4174.212,2456.092,10.000},
				{4415.045,2408.330,10.000},
				{4649.589,2345.445,10.000},
				{4876.424,2268.353,10.000},
				{5094.269,2178.442,10.000},
				{5302.037,2077.680,10.000},
				{5498.911,1968.745,10.000},
				{5684.425,1855.142,10.000},
				{5858.556,1741.311,10.000},
				{6021.826,1632.701,10.000},
				{6175.272,1534.454,10.000},
				{6320.587,1453.150,10.000},
				{6460.318,1397.313,10.000},
				{6597.836,1375.180,10.000},
				{6737.251,1394.145,10.000},
				{6883.270,1460.193,10.000},
				{7041.010,1577.401,10.000},
				{7215.767,1747.575,10.000},
				{7412.777,1970.095,10.000},
				{7636.976,2241.990,10.000},
				{7892.799,2558.231,10.000},
				{8184.018,2912.188,10.000},
				{8513.635,3296.173,10.000},
				{8883.835,3701.999,10.000},
				{9295.982,4121.470,10.000},
				{9750.659,4546.770,10.000},
				{10247.732,4970.730,10.000},
				{10786.633,5389.008,10.000},
				{11366.299,5796.659,10.000},
				{11985.015,6187.165,10.000},
				{12640.659,6556.437,10.000},
				{13330.756,6900.971,10.000},
				{14052.530,7217.736,10.000},
				{14802.936,7504.066,10.000},
				{15578.693,7757.570,10.000},
				{16376.300,7976.069,10.000},
				{17192.056,8157.561,10.000},
				{18022.077,8300.208,10.000},
				{18862.313,8402.360,10.000},
				{19708.573,8462.597,10.000},
				{20556.551,8479.786,10.000},
				{21401.867,8453.156,10.000},
				{22240.103,8382.364,10.000},
				{23066.860,8267.565,10.000},
				{23878.196,8113.366,10.000},
				{24671.093,7928.970,10.000},
				{25443.125,7720.313,10.000},
				{26192.100,7489.750,10.000},
				{26916.076,7239.765,10.000},
				{27613.369,6972.927,10.000},
				{28282.554,6691.849,10.000},
				{28922.468,6399.143,10.000},
				{29532.206,6097.375,10.000},
				{30111.108,5789.022,10.000},
				{30658.752,5476.437,10.000},
				{31174.933,5161.814,10.000},
				{31659.650,4847.169,10.000},
				{32113.081,4534.312,10.000},
				{32535.565,4224.842,10.000},
				{32927.579,3920.134,10.000},
				{33289.712,3621.335,10.000},
				{33622.648,3329.364,10.000},
				{33927.140,3044.917,10.000},
				{34203.987,2768.472,10.000},
				{34454.017,2500.296,10.000},
				{34678.062,2240.454,10.000},
				{34876.945,1988.824,10.000},
				{35051.778,1748.333,10.000},
				{35204.246,1524.684,10.000},
				{35336.247,1320.002,10.000},
				{35449.568,1133.213,10.000},
				{35545.899,963.308,10.000},
				{35626.835,809.360,10.000},
				{35693.889,670.540,10.000},
				{35748.501,546.119,10.000},
				{35792.048,435.477,10.000},
				{35825.858,338.096,10.000},
				{35851.214,253.558,10.000},
				{35869.367,181.536,10.000},
				{35881.546,121.788,10.000},
				{35888.961,74.143,10.000},
				{35892.810,38.491,10.000},
				{35894.286,14.766,10.000},
				{35894.580,2.940,10.000},
				{35894.580,0.000,10.000}
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