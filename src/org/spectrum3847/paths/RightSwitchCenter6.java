package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class RightSwitchCenter6 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (6.25,-4.75,0.00)
	
	public RightSwitchCenter6() {
		this(false);
	}
			
    public RightSwitchCenter6(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{-0.598,-11.951,10.000},
				{-2.988,-23.902,10.000},
				{-8.366,-53.777,10.000},
				{-17.925,-95.593,10.000},
				{-32.859,-149.338,10.000},
				{-54.357,-214.989,10.000},
				{-83.609,-292.514,10.000},
				{-121.796,-381.870,10.000},
				{-170.096,-482.997,10.000},
				{-229.677,-595.819,10.000},
				{-301.702,-720.244,10.000},
				{-387.317,-856.156,10.000},
				{-487.659,-1003.420,10.000},
				{-603.847,-1161.878,10.000},
				{-736.981,-1331.343,10.000},
				{-887.552,-1505.707,10.000},
				{-1055.443,-1678.907,10.000},
				{-1240.524,-1850.813,10.000},
				{-1442.654,-2021.300,10.000},
				{-1661.679,-2190.243,10.000},
				{-1897.431,-2357.521,10.000},
				{-2149.732,-2523.013,10.000},
				{-2418.392,-2686.602,10.000},
				{-2703.209,-2848.171,10.000},
				{-3003.970,-3007.604,10.000},
				{-3320.448,-3164.785,10.000},
				{-3652.408,-3319.600,10.000},
				{-3999.601,-3471.932,10.000},
				{-4361.768,-3621.663,10.000},
				{-4738.635,-3768.675,10.000},
				{-5129.920,-3912.844,10.000},
				{-5535.324,-4054.044,10.000},
				{-5954.538,-4192.142,10.000},
				{-6387.238,-4327.003,10.000},
				{-6833.087,-4458.480,10.000},
				{-7291.729,-4586.423,10.000},
				{-7762.796,-4710.668,10.000},
				{-8245.900,-4831.045,10.000},
				{-8740.637,-4947.370,10.000},
				{-9246.582,-5059.446,10.000},
				{-9763.288,-5167.065,10.000},
				{-10290.288,-5270.001,10.000},
				{-10827.090,-5368.014,10.000},
				{-11373.175,-5460.849,10.000},
				{-11927.998,-5548.233,10.000},
				{-12490.985,-5629.873,10.000},
				{-13061.532,-5705.465,10.000},
				{-13639.000,-5774.684,10.000},
				{-14222.720,-5837.194,10.000},
				{-14811.984,-5892.643,10.000},
				{-15406.051,-5940.674,10.000},
				{-16004.144,-5980.926,10.000},
				{-16605.448,-6013.039,10.000},
				{-17209.115,-6036.667,10.000},
				{-17814.264,-6051.491,10.000},
				{-18419.986,-6057.228,10.000},
				{-19025.352,-6053.655,10.000},
				{-19629.415,-6040.633,10.000},
				{-20231.228,-6018.133,10.000},
				{-20829.856,-5986.271,10.000},
				{-21424.390,-5945.349,10.000},
				{-22013.980,-5895.899,10.000},
				{-22597.508,-5835.278,10.000},
				{-23173.675,-5761.671,10.000},
				{-23741.415,-5677.392,10.000},
				{-24299.927,-5585.128,10.000},
				{-24848.720,-5487.926,10.000},
				{-25387.634,-5389.145,10.000},
				{-25916.872,-5292.380,10.000},
				{-26437.008,-5201.355,10.000},
				{-26948.986,-5119.778,10.000},
				{-27454.104,-5051.180,10.000},
				{-27953.977,-4998.732,10.000},
				{-28450.483,-4965.065,10.000},
				{-28945.694,-4952.111,10.000},
				{-29441.792,-4960.973,10.000},
				{-29940.977,-4991.856,10.000},
				{-30445.655,-5046.780,10.000},
				{-30958.370,-5127.147,10.000},
				{-31481.488,-5231.180,10.000},
				{-32017.156,-5356.685,10.000},
				{-32567.273,-5501.165,10.000},
				{-33133.466,-5661.935,10.000},
				{-33717.090,-5836.240,10.000},
				{-34319.225,-6021.350,10.000},
				{-34940.691,-6214.656,10.000},
				{-35582.064,-6413.726,10.000},
				{-36243.699,-6616.359,10.000},
				{-36925.760,-6820.607,10.000},
				{-37628.239,-7024.791,10.000},
				{-38350.989,-7227.497,10.000},
				{-39093.746,-7427.567,10.000},
				{-39856.153,-7624.077,10.000},
				{-40637.785,-7816.316,10.000},
				{-41438.161,-8003.765,10.000},
				{-42256.768,-8186.067,10.000},
				{-43093.069,-8363.006,10.000},
				{-43946.517,-8534.482,10.000},
				{-44816.566,-8700.494,10.000},
				{-45702.678,-8861.119,10.000},
				{-46604.328,-9016.498,10.000},
				{-47521.010,-9166.821,10.000},
				{-48452.242,-9312.315,10.000},
				{-49397.565,-9453.239,10.000},
				{-50356.552,-9589.870,10.000},
				{-51328.803,-9722.503,10.000},
				{-52313.947,-9851.442,10.000},
				{-53311.646,-9976.995,10.000},
				{-54321.594,-10099.476,10.000},
				{-55343.514,-10219.199,10.000},
				{-56377.162,-10336.478,10.000},
				{-57422.324,-10451.626,10.000},
				{-58478.820,-10564.952,10.000},
				{-59546.496,-10676.765,10.000},
				{-60625.233,-10787.370,10.000},
				{-61714.940,-10897.072,10.000},
				{-62815.558,-11006.173,10.000},
				{-63927.055,-11114.973,10.000},
				{-65049.432,-11223.773,10.000},
				{-66182.719,-11332.873,10.000},
				{-67326.977,-11442.575,10.000},
				{-68482.295,-11553.180,10.000},
				{-69648.794,-11664.993,10.000},
				{-70826.626,-11778.319,10.000},
				{-72015.973,-11893.467,10.000},
				{-73217.048,-12010.746,10.000},
				{-74430.094,-12130.469,10.000},
				{-75655.389,-12252.949,10.000},
				{-76893.239,-12378.502,10.000},
				{-78143.983,-12507.439,10.000},
				{-79407.990,-12640.070,10.000},
				{-80685.660,-12776.700,10.000},
				{-81977.422,-12917.620,10.000},
				{-83283.734,-13063.111,10.000},
				{-84605.076,-13213.429,10.000},
				{-85941.957,-13368.802,10.000},
				{-87294.899,-13529.420,10.000},
				{-88664.441,-13695.423,10.000},
				{-90051.130,-13866.889,10.000},
				{-91455.511,-14043.815,10.000},
				{-92878.121,-14226.102,10.000},
				{-94319.475,-14413.533,10.000},
				{-95780.050,-14605.751,10.000},
				{-97260.273,-14802.236,10.000},
				{-98760.501,-15002.277,10.000},
				{-100280.996,-15204.951,10.000},
				{-101821.906,-15409.098,10.000},
				{-103383.236,-15613.304,10.000},
				{-104964.825,-15815.889,10.000},
				{-106566.316,-16014.907,10.000},
				{-108187.132,-16208.156,10.000},
				{-109826.452,-16393.206,10.000},
				{-111483.197,-16567.445,10.000},
				{-113156.011,-16728.148,10.000},
				{-114843.267,-16872.558,10.000},
				{-116543.066,-16997.992,10.000},
				{-118253.262,-17101.955,10.000},
				{-119971.487,-17182.255,10.000},
				{-121695.197,-17237.098,10.000},
				{-123420.791,-17255.938,10.000},
				{-125143.677,-17228.864,10.000},
				{-126859.286,-17156.083,10.000},
				{-128563.156,-17038.699,10.000},
				{-130251.020,-16878.644,10.000},
				{-131918.875,-16678.548,10.000},
				{-133563.033,-16441.583,10.000},
				{-135180.161,-16171.277,10.000},
				{-136767.295,-15871.338,10.000},
				{-138321.843,-15545.488,10.000},
				{-139841.575,-15197.320,10.000},
				{-141324.595,-14830.192,10.000},
				{-142769.309,-14447.149,10.000},
				{-144174.397,-14050.877,10.000},
				{-145538.767,-13643.703,10.000},
				{-146862.344,-13235.763,10.000},
				{-148145.979,-12836.348,10.000},
				{-149390.578,-12445.990,10.000},
				{-150597.077,-12064.990,10.000},
				{-151766.423,-11693.465,10.000},
				{-152899.562,-11331.386,10.000},
				{-153997.423,-10978.613,10.000},
				{-155060.915,-10634.924,10.000},
				{-156090.919,-10300.038,10.000},
				{-157088.283,-9973.634,10.000},
				{-158053.819,-9655.366,10.000},
				{-158988.307,-9344.875,10.000},
				{-159892.487,-9041.801,10.000},
				{-160767.065,-8745.785,10.000},
				{-161612.713,-8456.477,10.000},
				{-162430.067,-8173.541,10.000},
				{-163219.732,-7896.652,10.000},
				{-163982.283,-7625.505,10.000},
				{-164718.264,-7359.808,10.000},
				{-165428.192,-7099.289,10.000},
				{-166112.562,-6843.692,10.000},
				{-166771.839,-6592.776,10.000},
				{-167406.471,-6346.317,10.000},
				{-168016.882,-6104.106,10.000},
				{-168603.476,-5865.947,10.000},
				{-169166.642,-5631.656,10.000},
				{-169706.748,-5401.062,10.000},
				{-170224.148,-5174.002,10.000},
				{-170719.181,-4950.325,10.000},
				{-171192.169,-4729.885,10.000},
				{-171643.424,-4512.546,10.000},
				{-172073.242,-4298.177,10.000},
				{-172481.907,-4086.649,10.000},
				{-172869.691,-3877.842,10.000},
				{-173236.854,-3671.634,10.000},
				{-173583.645,-3467.909,10.000},
				{-173910.300,-3266.551,10.000},
				{-174217.044,-3067.443,10.000},
				{-174504.092,-2870.471,10.000},
				{-174771.644,-2675.520,10.000},
				{-175019.891,-2482.471,10.000},
				{-175249.012,-2291.208,10.000},
				{-175459.173,-2101.610,10.000},
				{-175650.528,-1913.555,10.000},
				{-175823.220,-1726.919,10.000},
				{-175977.378,-1541.577,10.000},
				{-176113.119,-1357.410,10.000},
				{-176231.149,-1180.307,10.000},
				{-176332.759,-1016.098,10.000},
				{-176419.219,-864.599,10.000},
				{-176491.784,-725.650,10.000},
				{-176551.696,-599.117,10.000},
				{-176600.184,-484.884,10.000},
				{-176638.470,-382.858,10.000},
				{-176667.766,-292.964,10.000},
				{-176689.281,-215.143,10.000},
				{-176704.215,-149.350,10.000},
				{-176713.771,-95.553,10.000},
				{-176719.144,-53.731,10.000},
				{-176721.531,-23.870,10.000},
				{-176722.127,-5.965,10.000},
				{-176722.127,-0.000,10.000}
		};
		
		double[][] rightPoints = {
				{-0.598,-11.951,10.000},
				{-2.988,-23.904,10.000},
				{-8.367,-53.786,10.000},
				{-17.930,-95.630,10.000},
				{-32.874,-149.449,10.000},
				{-54.401,-215.265,10.000},
				{-83.712,-293.108,10.000},
				{-122.014,-383.025,10.000},
				{-170.522,-485.073,10.000},
				{-230.454,-599.328,10.000},
				{-303.043,-725.885,10.000},
				{-389.529,-864.857,10.000},
				{-491.166,-1016.379,10.000},
				{-609.228,-1180.611,10.000},
				{-745.001,-1357.739,10.000},
				{-899.193,-1541.919,10.000},
				{-1071.920,-1727.263,10.000},
				{-1263.310,-1913.901,10.000},
				{-1473.506,-2101.959,10.000},
				{-1702.662,-2291.560,10.000},
				{-1950.944,-2482.827,10.000},
				{-2218.532,-2675.878,10.000},
				{-2505.616,-2870.834,10.000},
				{-2812.396,-3067.809,10.000},
				{-3139.089,-3266.921,10.000},
				{-3485.917,-3468.283,10.000},
				{-3853.118,-3672.013,10.000},
				{-4240.941,-3878.225,10.000},
				{-4649.644,-4087.038,10.000},
				{-5079.501,-4298.570,10.000},
				{-5530.796,-4512.945,10.000},
				{-6003.825,-4730.290,10.000},
				{-6498.898,-4950.735,10.000},
				{-7016.340,-5174.418,10.000},
				{-7556.489,-5401.484,10.000},
				{-8119.697,-5632.086,10.000},
				{-8706.336,-5866.384,10.000},
				{-9316.791,-6104.550,10.000},
				{-9951.468,-6346.769,10.000},
				{-10610.791,-6593.235,10.000},
				{-11295.207,-6844.159,10.000},
				{-12005.184,-7099.766,10.000},
				{-12741.213,-7360.294,10.000},
				{-13503.813,-7626.000,10.000},
				{-14293.529,-7897.158,10.000},
				{-15110.934,-8174.058,10.000},
				{-15956.635,-8457.006,10.000},
				{-16831.268,-8746.325,10.000},
				{-17735.503,-9042.354,10.000},
				{-18670.047,-9345.441,10.000},
				{-19635.642,-9655.946,10.000},
				{-20633.065,-9974.229,10.000},
				{-21663.129,-10300.649,10.000},
				{-22726.684,-10635.550,10.000},
				{-23824.610,-10979.256,10.000},
				{-24957.815,-11332.045,10.000},
				{-26127.229,-11694.142,10.000},
				{-27333.797,-12065.684,10.000},
				{-28578.467,-12446.702,10.000},
				{-29862.175,-12837.077,10.000},
				{-31185.826,-13236.508,10.000},
				{-32550.272,-13644.463,10.000},
				{-33955.436,-14051.634,10.000},
				{-35400.224,-14447.884,10.000},
				{-36883.314,-14830.901,10.000},
				{-38403.114,-15197.998,10.000},
				{-39957.727,-15546.128,10.000},
				{-41544.920,-15871.934,10.000},
				{-43162.102,-16171.821,10.000},
				{-44806.309,-16442.069,10.000},
				{-46474.206,-16678.970,10.000},
				{-48162.106,-16878.994,10.000},
				{-49866.003,-17038.973,10.000},
				{-51581.631,-17156.276,10.000},
				{-53304.528,-17228.974,10.000},
				{-55030.124,-17255.963,10.000},
				{-56753.828,-17237.038,10.000},
				{-58472.041,-17182.129,10.000},
				{-60182.219,-17101.784,10.000},
				{-61881.997,-16997.779,10.000},
				{-63569.228,-16872.307,10.000},
				{-65242.014,-16727.864,10.000},
				{-66898.728,-16567.134,10.000},
				{-68538.015,-16392.872,10.000},
				{-70158.796,-16207.805,10.000},
				{-71760.250,-16014.543,10.000},
				{-73341.802,-15815.517,10.000},
				{-74903.094,-15612.926,10.000},
				{-76443.966,-15408.719,10.000},
				{-77964.423,-15204.574,10.000},
				{-79464.614,-15001.904,10.000},
				{-80944.801,-14801.868,10.000},
				{-82405.340,-14605.391,10.000},
				{-83846.658,-14413.181,10.000},
				{-85269.234,-14225.759,10.000},
				{-86673.582,-14043.482,10.000},
				{-88060.239,-13866.566,10.000},
				{-89429.750,-13695.111,10.000},
				{-90782.661,-13529.117,10.000},
				{-92119.512,-13368.509,10.000},
				{-93440.827,-13213.146,10.000},
				{-94747.111,-13062.837,10.000},
				{-96038.846,-12917.355,10.000},
				{-97316.490,-12776.443,10.000},
				{-98580.473,-12639.821,10.000},
				{-99831.192,-12507.197,10.000},
				{-101069.019,-12378.266,10.000},
				{-102294.291,-12252.720,10.000},
				{-103507.315,-12130.245,10.000},
				{-104708.368,-12010.526,10.000},
				{-105897.693,-11893.252,10.000},
				{-107075.504,-11778.108,10.000},
				{-108241.982,-11664.785,10.000},
				{-109397.280,-11552.975,10.000},
				{-110541.517,-11442.371,10.000},
				{-111674.784,-11332.671,10.000},
				{-112797.141,-11223.571,10.000},
				{-113908.618,-11114.771,10.000},
				{-115009.215,-11005.971,10.000},
				{-116098.902,-10896.870,10.000},
				{-117177.619,-10787.167,10.000},
				{-118245.275,-10676.559,10.000},
				{-119301.749,-10564.744,10.000},
				{-120346.891,-10451.414,10.000},
				{-121380.517,-10336.263,10.000},
				{-122402.415,-10218.980,10.000},
				{-123412.340,-10099.252,10.000},
				{-124410.017,-9976.765,10.000},
				{-125395.137,-9851.206,10.000},
				{-126367.363,-9722.261,10.000},
				{-127326.325,-9589.621,10.000},
				{-128271.624,-9452.982,10.000},
				{-129202.829,-9312.050,10.000},
				{-130119.483,-9166.547,10.000},
				{-131021.105,-9016.215,10.000},
				{-131907.187,-8860.827,10.000},
				{-132777.207,-8700.192,10.000},
				{-133630.624,-8534.169,10.000},
				{-134466.892,-8362.683,10.000},
				{-135285.465,-8185.734,10.000},
				{-136085.808,-8003.423,10.000},
				{-136867.404,-7815.964,10.000},
				{-137629.776,-7623.716,10.000},
				{-138372.496,-7427.200,10.000},
				{-139095.208,-7227.124,10.000},
				{-139797.649,-7024.414,10.000},
				{-140479.672,-6820.228,10.000},
				{-141141.270,-6615.981,10.000},
				{-141782.606,-6413.353,10.000},
				{-142404.035,-6214.292,10.000},
				{-143006.135,-6020.999,10.000},
				{-143589.725,-5835.906,10.000},
				{-144155.888,-5661.624,10.000},
				{-144705.976,-5500.881,10.000},
				{-145241.619,-5356.434,10.000},
				{-145764.716,-5230.966,10.000},
				{-146277.414,-5126.975,10.000},
				{-146782.079,-5046.654,10.000},
				{-147281.256,-4991.773,10.000},
				{-147777.349,-4960.931,10.000},
				{-148272.560,-4952.110,10.000},
				{-148769.071,-4965.104,10.000},
				{-149268.951,-4998.807,10.000},
				{-149774.080,-5051.287,10.000},
				{-150286.071,-5119.912,10.000},
				{-150806.222,-5201.509,10.000},
				{-151335.477,-5292.548,10.000},
				{-151874.409,-5389.320,10.000},
				{-152423.219,-5488.101,10.000},
				{-152981.749,-5585.296,10.000},
				{-153549.504,-5677.548,10.000},
				{-154125.685,-5761.809,10.000},
				{-154709.224,-5835.394,10.000},
				{-155298.824,-5895.996,10.000},
				{-155893.367,-5945.430,10.000},
				{-156492.000,-5986.336,10.000},
				{-157093.818,-6018.181,10.000},
				{-157697.885,-6040.663,10.000},
				{-158303.251,-6053.668,10.000},
				{-158908.974,-6057.223,10.000},
				{-159514.121,-6051.469,10.000},
				{-160117.784,-6036.630,10.000},
				{-160719.082,-6012.985,10.000},
				{-161317.168,-5980.857,10.000},
				{-161911.227,-5940.591,10.000},
				{-162500.481,-5892.545,10.000},
				{-163084.190,-5837.083,10.000},
				{-163661.646,-5774.561,10.000},
				{-164232.179,-5705.329,10.000},
				{-164795.151,-5629.726,10.000},
				{-165349.959,-5548.074,10.000},
				{-165896.027,-5460.681,10.000},
				{-166432.810,-5367.836,10.000},
				{-166959.792,-5269.813,10.000},
				{-167476.478,-5166.868,10.000},
				{-167982.403,-5059.241,10.000},
				{-168477.118,-4947.157,10.000},
				{-168960.201,-4830.825,10.000},
				{-169431.245,-4710.441,10.000},
				{-169889.864,-4586.188,10.000},
				{-170335.687,-4458.239,10.000},
				{-170768.363,-4326.755,10.000},
				{-171187.552,-4191.888,10.000},
				{-171592.930,-4053.784,10.000},
				{-171984.188,-3912.579,10.000},
				{-172361.029,-3768.405,10.000},
				{-172723.167,-3621.388,10.000},
				{-173070.332,-3471.651,10.000},
				{-173402.264,-3319.315,10.000},
				{-173718.713,-3164.495,10.000},
				{-174019.444,-3007.310,10.000},
				{-174304.232,-2847.873,10.000},
				{-174572.862,-2686.300,10.000},
				{-174825.133,-2522.708,10.000},
				{-175060.854,-2357.212,10.000},
				{-175279.847,-2189.931,10.000},
				{-175481.945,-2020.985,10.000},
				{-175666.995,-1850.496,10.000},
				{-175834.854,-1678.587,10.000},
				{-175985.392,-1505.385,10.000},
				{-176118.495,-1331.030,10.000},
				{-176234.654,-1161.585,10.000},
				{-176334.968,-1003.148,10.000},
				{-176420.559,-855.904,10.000},
				{-176492.560,-720.013,10.000},
				{-176552.121,-595.610,10.000},
				{-176600.402,-482.809,10.000},
				{-176638.573,-381.704,10.000},
				{-176667.810,-292.371,10.000},
				{-176689.296,-214.867,10.000},
				{-176704.220,-149.238,10.000},
				{-176713.772,-95.516,10.000},
				{-176719.144,-53.722,10.000},
				{-176721.531,-23.869,10.000},
				{-176722.127,-5.965,10.000},
				{-176722.127,-0.000,10.000}
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