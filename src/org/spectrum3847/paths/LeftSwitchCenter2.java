package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class LeftSwitchCenter2 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (6.00,5.50,0.00)
	
	public LeftSwitchCenter2() {
		this(false);
	}
			
    public LeftSwitchCenter2(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{-0.587,-11.749,10.000},
				{-2.937,-23.499,10.000},
				{-8.225,-52.876,10.000},
				{-17.626,-94.009,10.000},
				{-32.317,-146.911,10.000},
				{-53.477,-211.598,10.000},
				{-82.286,-288.095,10.000},
				{-119.930,-376.439,10.000},
				{-167.598,-476.676,10.000},
				{-226.484,-588.866,10.000},
				{-297.793,-713.084,10.000},
				{-382.735,-849.421,10.000},
				{-481.943,-992.077,10.000},
				{-595.466,-1135.232,10.000},
				{-723.361,-1278.952,10.000},
				{-865.692,-1423.308,10.000},
				{-1022.528,-1568.365,10.000},
				{-1193.947,-1714.189,10.000},
				{-1380.032,-1860.847,10.000},
				{-1580.872,-2008.402,10.000},
				{-1796.564,-2156.918,10.000},
				{-2027.210,-2306.458,10.000},
				{-2272.918,-2457.084,10.000},
				{-2533.804,-2608.859,10.000},
				{-2809.988,-2761.843,10.000},
				{-3101.598,-2916.099,10.000},
				{-3408.767,-3071.689,10.000},
				{-3731.634,-3228.674,10.000},
				{-4070.346,-3387.118,10.000},
				{-4425.055,-3547.084,10.000},
				{-4795.919,-3708.639,10.000},
				{-5183.104,-3871.850,10.000},
				{-5586.782,-4036.787,10.000},
				{-6007.134,-4203.521,10.000},
				{-6444.347,-4372.129,10.000},
				{-6898.616,-4542.690,10.000},
				{-7370.145,-4715.289,10.000},
				{-7859.146,-4890.013,10.000},
				{-8365.842,-5066.958,10.000},
				{-8890.465,-5246.225,10.000},
				{-9433.257,-5427.920,10.000},
				{-9994.473,-5612.161,10.000},
				{-10574.380,-5799.071,10.000},
				{-11172.600,-5982.199,10.000},
				{-11788.091,-6154.914,10.000},
				{-12419.796,-6317.049,10.000},
				{-13066.638,-6468.425,10.000},
				{-13727.523,-6608.844,10.000},
				{-14401.332,-6738.096,10.000},
				{-15086.928,-6855.956,10.000},
				{-15783.146,-6962.180,10.000},
				{-16488.797,-7056.508,10.000},
				{-17202.663,-7138.662,10.000},
				{-17923.498,-7208.345,10.000},
				{-18650.022,-7265.242,10.000},
				{-19381.635,-7316.128,10.000},
				{-20118.436,-7368.017,10.000},
				{-20860.531,-7420.949,10.000},
				{-21608.027,-7474.963,10.000},
				{-22361.037,-7530.097,10.000},
				{-23119.676,-7586.384,10.000},
				{-23884.061,-7643.854,10.000},
				{-24654.314,-7702.533,10.000},
				{-25430.558,-7762.442,10.000},
				{-26212.918,-7823.598,10.000},
				{-27001.519,-7886.010,10.000},
				{-27796.487,-7949.682,10.000},
				{-28597.948,-8014.607,10.000},
				{-29406.025,-8080.773,10.000},
				{-30220.841,-8148.155,10.000},
				{-31042.513,-8216.718,10.000},
				{-31871.154,-8286.415,10.000},
				{-32706.873,-8357.185,10.000},
				{-33549.768,-8428.953,10.000},
				{-34399.930,-8501.626,10.000},
				{-35257.440,-8575.096,10.000},
				{-36122.364,-8649.235,10.000},
				{-36994.753,-8723.896,10.000},
				{-37874.644,-8798.909,10.000},
				{-38762.053,-8874.085,10.000},
				{-39656.974,-8949.212,10.000},
				{-40559.379,-9024.054,10.000},
				{-41469.215,-9098.353,10.000},
				{-42386.397,-9171.828,10.000},
				{-43310.815,-9244.177,10.000},
				{-44242.323,-9315.078,10.000},
				{-45180.742,-9384.190,10.000},
				{-46125.857,-9451.156,10.000},
				{-47077.418,-9515.607,10.000},
				{-48035.135,-9577.165,10.000},
				{-48998.679,-9635.448,10.000},
				{-49967.687,-9690.074,10.000},
				{-50941.754,-9740.667,10.000},
				{-51920.440,-9786.864,10.000},
				{-52903.272,-9828.320,10.000},
				{-53889.743,-9864.713,10.000},
				{-54879.319,-9895.754,10.000},
				{-55871.438,-9921.188,10.000},
				{-56865.518,-9940.802,10.000},
				{-57860.961,-9954.430,10.000},
				{-58857.156,-9961.954,10.000},
				{-59853.487,-9963.309,10.000},
				{-60849.335,-9958.485,10.000},
				{-61844.088,-9947.524,10.000},
				{-62837.140,-9930.523,10.000},
				{-63827.903,-9907.628,10.000},
				{-64815.806,-9879.034,10.000},
				{-65800.304,-9844.981,10.000},
				{-66780.879,-9805.744,10.000},
				{-67757.042,-9761.635,10.000},
				{-68728.341,-9712.991,10.000},
				{-69694.358,-9660.170,10.000},
				{-70654.713,-9603.547,10.000},
				{-71609.063,-9543.503,10.000},
				{-72557.106,-9480.424,10.000},
				{-73498.575,-9414.692,10.000},
				{-74433.243,-9346.686,10.000},
				{-75360.920,-9276.769,10.000},
				{-76281.450,-9205.294,10.000},
				{-77194.709,-9132.594,10.000},
				{-78100.608,-9058.984,10.000},
				{-78999.083,-8984.756,10.000},
				{-79890.101,-8910.183,10.000},
				{-80773.653,-8835.512,10.000},
				{-81649.750,-8760.969,10.000},
				{-82518.425,-8686.759,10.000},
				{-83379.732,-8613.061,10.000},
				{-84233.735,-8540.036,10.000},
				{-85080.517,-8467.823,10.000},
				{-85920.172,-8396.544,10.000},
				{-86752.802,-8326.301,10.000},
				{-87578.520,-8257.180,10.000},
				{-88397.445,-8189.253,10.000},
				{-89209.703,-8122.576,10.000},
				{-90015.422,-8057.194,10.000},
				{-90814.736,-7993.140,10.000},
				{-91607.780,-7930.436,10.000},
				{-92394.690,-7869.097,10.000},
				{-93175.602,-7809.127,10.000},
				{-93950.655,-7750.525,10.000},
				{-94719.983,-7693.283,10.000},
				{-95483.722,-7637.389,10.000},
				{-96242.004,-7582.823,10.000},
				{-96994.961,-7529.564,10.000},
				{-97742.719,-7477.587,10.000},
				{-98485.406,-7426.864,10.000},
				{-99223.142,-7377.365,10.000},
				{-99956.048,-7329.057,10.000},
				{-100684.238,-7281.906,10.000},
				{-101407.826,-7235.877,10.000},
				{-102126.920,-7190.936,10.000},
				{-102841.624,-7147.044,10.000},
				{-103552.041,-7104.166,10.000},
				{-104258.267,-7062.265,10.000},
				{-104960.397,-7021.302,10.000},
				{-105658.522,-6981.242,10.000},
				{-106352.726,-6942.047,10.000},
				{-107043.095,-6903.682,10.000},
				{-107729.705,-6866.109,10.000},
				{-108412.635,-6829.293,10.000},
				{-109091.955,-6793.200,10.000},
				{-109767.734,-6757.793,10.000},
				{-110440.038,-6723.040,10.000},
				{-111108.929,-6688.907,10.000},
				{-111774.465,-6655.360,10.000},
				{-112436.702,-6622.368,10.000},
				{-113095.691,-6589.898,10.000},
				{-113751.483,-6557.920,10.000},
				{-114404.124,-6526.402,10.000},
				{-115053.655,-6495.315,10.000},
				{-115700.118,-6464.628,10.000},
				{-116343.549,-6434.314,10.000},
				{-116983.983,-6404.342,10.000},
				{-117621.452,-6374.685,10.000},
				{-118255.984,-6345.316,10.000},
				{-118887.604,-6316.206,10.000},
				{-119516.337,-6287.328,10.000},
				{-120142.203,-6258.657,10.000},
				{-120765.219,-6230.165,10.000},
				{-121385.402,-6201.825,10.000},
				{-122002.763,-6173.613,10.000},
				{-122617.313,-6145.502,10.000},
				{-123229.060,-6117.467,10.000},
				{-123838.008,-6089.482,10.000},
				{-124444.160,-6061.521,10.000},
				{-125047.516,-6033.559,10.000},
				{-125648.073,-6005.570,10.000},
				{-126245.826,-5977.529,10.000},
				{-126840.767,-5949.411,10.000},
				{-127432.886,-5921.190,10.000},
				{-128022.170,-5892.839,10.000},
				{-128608.603,-5864.333,10.000},
				{-129192.168,-5835.645,10.000},
				{-129772.843,-5806.750,10.000},
				{-130350.605,-5777.619,10.000},
				{-130925.427,-5748.227,10.000},
				{-131497.282,-5718.546,10.000},
				{-132066.137,-5688.547,10.000},
				{-132631.957,-5658.203,10.000},
				{-133194.705,-5627.485,10.000},
				{-133754.342,-5596.363,10.000},
				{-134310.823,-5564.809,10.000},
				{-134864.102,-5532.791,10.000},
				{-135414.130,-5500.280,10.000},
				{-135960.854,-5467.243,10.000},
				{-136504.219,-5433.649,10.000},
				{-137044.166,-5399.466,10.000},
				{-137580.632,-5364.661,10.000},
				{-138113.552,-5329.199,10.000},
				{-138642.856,-5293.048,10.000},
				{-139168.474,-5256.171,10.000},
				{-139690.327,-5218.534,10.000},
				{-140208.337,-5180.102,10.000},
				{-140722.421,-5140.837,10.000},
				{-141232.491,-5100.704,10.000},
				{-141738.458,-5059.666,10.000},
				{-142240.226,-5017.685,10.000},
				{-142737.699,-4974.725,10.000},
				{-143230.774,-4930.748,10.000},
				{-143719.345,-4885.718,10.000},
				{-144203.305,-4839.598,10.000},
				{-144682.541,-4792.353,10.000},
				{-145156.935,-4743.948,10.000},
				{-145626.370,-4694.348,10.000},
				{-146090.723,-4643.523,10.000},
				{-146549.867,-4591.441,10.000},
				{-147003.674,-4538.075,10.000},
				{-147452.014,-4483.400,10.000},
				{-147894.753,-4427.394,10.000},
				{-148331.757,-4370.039,10.000},
				{-148762.890,-4311.324,10.000},
				{-149188.014,-4251.240,10.000},
				{-149606.992,-4189.787,10.000},
				{-150019.689,-4126.970,10.000},
				{-150425.970,-4062.803,10.000},
				{-150825.701,-3997.311,10.000},
				{-151218.754,-3930.527,10.000},
				{-151605.003,-3862.497,10.000},
				{-151984.331,-3793.278,10.000},
				{-152356.626,-3722.943,10.000},
				{-152721.784,-3651.580,10.000},
				{-153079.713,-3579.292,10.000},
				{-153430.333,-3506.203,10.000},
				{-153773.578,-3432.452,10.000},
				{-154109.398,-3358.202,10.000},
				{-154437.762,-3283.637,10.000},
				{-154758.658,-3208.960,10.000},
				{-155072.098,-3134.400,10.000},
				{-155378.119,-3060.206,10.000},
				{-155676.784,-2986.653,10.000},
				{-155968.187,-2914.035,10.000},
				{-156252.454,-2842.668,10.000},
				{-156529.743,-2772.888,10.000},
				{-156800.248,-2705.047,10.000},
				{-157064.199,-2639.512,10.000},
				{-157321.865,-2576.660,10.000},
				{-157573.552,-2516.874,10.000},
				{-157819.607,-2460.541,10.000},
				{-158060.411,-2408.042,10.000},
				{-158296.386,-2359.749,10.000},
				{-158527.988,-2316.020,10.000},
				{-158755.707,-2277.190,10.000},
				{-158980.063,-2243.567,10.000},
				{-159201.606,-2215.426,10.000},
				{-159420.906,-2193.002,10.000},
				{-159638.555,-2176.485,10.000},
				{-159855.157,-2166.020,10.000},
				{-160071.326,-2161.697,10.000},
				{-160287.682,-2163.555,10.000},
				{-160504.840,-2171.579,10.000},
				{-160723.410,-2185.700,10.000},
				{-160943.989,-2205.796,10.000},
				{-161167.159,-2231.697,10.000},
				{-161393.478,-2263.186,10.000},
				{-161623.478,-2300.006,10.000},
				{-161857.665,-2341.864,10.000},
				{-162096.508,-2388.436,10.000},
				{-162340.446,-2439.375,10.000},
				{-162589.878,-2494.318,10.000},
				{-162845.166,-2552.886,10.000},
				{-163106.636,-2614.699,10.000},
				{-163374.574,-2679.374,10.000},
				{-163649.227,-2746.534,10.000},
				{-163930.808,-2815.810,10.000},
				{-164219.493,-2886.847,10.000},
				{-164515.424,-2959.306,10.000},
				{-164818.710,-3032.864,10.000},
				{-165129.432,-3107.223,10.000},
				{-165447.643,-3182.103,10.000},
				{-165773.367,-3257.247,10.000},
				{-166106.610,-3332.423,10.000},
				{-166447.351,-3407.419,10.000},
				{-166795.556,-3482.048,10.000},
				{-167151.171,-3556.143,10.000},
				{-167514.126,-3629.557,10.000},
				{-167884.343,-3702.165,10.000},
				{-168261.729,-3773.859,10.000},
				{-168646.184,-3844.549,10.000},
				{-169037.599,-3914.159,10.000},
				{-169435.863,-3982.631,10.000},
				{-169840.854,-4049.919,10.000},
				{-170252.453,-4115.988,10.000},
				{-170670.535,-4180.815,10.000},
				{-171094.973,-4244.387,10.000},
				{-171525.643,-4306.699,10.000},
				{-171962.419,-4367.756,10.000},
				{-172405.176,-4427.567,10.000},
				{-172853.790,-4486.149,10.000},
				{-173308.143,-4543.524,10.000},
				{-173768.115,-4599.718,10.000},
				{-174233.591,-4654.761,10.000},
				{-174704.460,-4708.688,10.000},
				{-175180.613,-4761.535,10.000},
				{-175661.947,-4813.342,10.000},
				{-176148.324,-4863.766,10.000},
				{-176639.129,-4908.048,10.000},
				{-177133.288,-4941.593,10.000},
				{-177629.697,-4964.085,10.000},
				{-178127.219,-4975.229,10.000},
				{-178624.694,-4974.749,10.000},
				{-179120.933,-4962.385,10.000},
				{-179614.723,-4937.897,10.000},
				{-180104.829,-4901.060,10.000},
				{-180589.995,-4851.663,10.000},
				{-181068.946,-4789.513,10.000},
				{-181540.389,-4714.431,10.000},
				{-182003.057,-4626.675,10.000},
				{-182456.195,-4531.381,10.000},
				{-182899.538,-4433.427,10.000},
				{-183332.832,-4332.939,10.000},
				{-183755.834,-4230.029,10.000},
				{-184168.315,-4124.807,10.000},
				{-184570.052,-4017.373,10.000},
				{-184960.834,-3907.819,10.000},
				{-185340.458,-3796.236,10.000},
				{-185708.728,-3682.705,10.000},
				{-186065.459,-3567.307,10.000},
				{-186410.471,-3450.118,10.000},
				{-186743.592,-3331.208,10.000},
				{-187064.656,-3210.648,10.000},
				{-187373.507,-3088.505,10.000},
				{-187669.991,-2964.845,10.000},
				{-187953.965,-2839.731,10.000},
				{-188225.287,-2713.226,10.000},
				{-188483.826,-2585.393,10.000},
				{-188729.456,-2456.294,10.000},
				{-188962.055,-2325.990,10.000},
				{-189181.509,-2194.542,10.000},
				{-189387.710,-2062.013,10.000},
				{-189580.557,-1928.465,10.000},
				{-189759.953,-1793.962,10.000},
				{-189925.810,-1658.566,10.000},
				{-190078.044,-1522.342,10.000},
				{-190216.580,-1385.356,10.000},
				{-190341.347,-1247.675,10.000},
				{-190452.283,-1109.364,10.000},
				{-190549.332,-970.491,10.000},
				{-190632.493,-831.603,10.000},
				{-190702.356,-698.629,10.000},
				{-190760.060,-577.042,10.000},
				{-190806.753,-466.932,10.000},
				{-190843.590,-368.373,10.000},
				{-190871.733,-281.423,10.000},
				{-190892.346,-206.129,10.000},
				{-190906.598,-142.525,10.000},
				{-190915.662,-90.637,10.000},
				{-190920.710,-50.480,10.000},
				{-190922.916,-22.065,10.000},
				{-190923.456,-5.397,10.000},
				{-190923.456,-0.000,10.000}
		};
		
		double[][] rightPoints = {
				{-0.587,-11.749,10.000},
				{-2.937,-23.498,10.000},
				{-8.224,-52.868,10.000},
				{-17.622,-93.980,10.000},
				{-32.304,-146.822,10.000},
				{-53.442,-211.378,10.000},
				{-82.204,-287.622,10.000},
				{-119.756,-375.519,10.000},
				{-167.258,-475.021,10.000},
				{-225.865,-586.068,10.000},
				{-296.724,-708.586,10.000},
				{-380.972,-842.483,10.000},
				{-479.153,-981.811,10.000},
				{-591.217,-1120.641,10.000},
				{-717.108,-1258.904,10.000},
				{-856.761,-1396.533,10.000},
				{-1010.107,-1533.460,10.000},
				{-1177.069,-1669.620,10.000},
				{-1357.564,-1804.946,10.000},
				{-1551.501,-1939.375,10.000},
				{-1758.785,-2072.843,10.000},
				{-1979.314,-2205.287,10.000},
				{-2212.979,-2336.645,10.000},
				{-2459.664,-2466.854,10.000},
				{-2719.249,-2595.854,10.000},
				{-2991.608,-2723.582,10.000},
				{-3276.605,-2849.976,10.000},
				{-3574.103,-2974.975,10.000},
				{-3883.954,-3098.516,10.000},
				{-4206.008,-3220.533,10.000},
				{-4540.104,-3340.962,10.000},
				{-4886.077,-3459.735,10.000},
				{-5243.756,-3576.783,10.000},
				{-5612.959,-3692.032,10.000},
				{-5993.500,-3805.408,10.000},
				{-6385.183,-3916.831,10.000},
				{-6787.804,-4026.216,10.000},
				{-7201.152,-4133.476,10.000},
				{-7625.003,-4238.514,10.000},
				{-8059.127,-4341.232,10.000},
				{-8503.279,-4441.520,10.000},
				{-8957.205,-4539.263,10.000},
				{-9420.638,-4634.336,10.000},
				{-9892.783,-4721.442,10.000},
				{-10372.329,-4795.462,10.000},
				{-10857.985,-4856.563,10.000},
				{-11348.478,-4904.926,10.000},
				{-11842.552,-4940.745,10.000},
				{-12338.976,-4964.233,10.000},
				{-12836.537,-4975.615,10.000},
				{-13334.050,-4975.134,10.000},
				{-13830.355,-4963.050,10.000},
				{-14324.319,-4939.641,10.000},
				{-14814.840,-4905.204,10.000},
				{-15300.845,-4860.055,10.000},
				{-15781.762,-4809.167,10.000},
				{-16257.490,-4757.277,10.000},
				{-16727.924,-4704.343,10.000},
				{-17192.957,-4650.327,10.000},
				{-17652.476,-4595.191,10.000},
				{-18106.366,-4538.902,10.000},
				{-18554.509,-4481.430,10.000},
				{-18996.784,-4422.749,10.000},
				{-19433.068,-4362.837,10.000},
				{-19863.236,-4301.678,10.000},
				{-20287.162,-4239.264,10.000},
				{-20704.721,-4175.589,10.000},
				{-21115.787,-4110.661,10.000},
				{-21520.236,-4044.492,10.000},
				{-21917.947,-3977.106,10.000},
				{-22308.801,-3908.540,10.000},
				{-22692.685,-3838.839,10.000},
				{-23069.491,-3768.065,10.000},
				{-23439.120,-3696.293,10.000},
				{-23801.482,-3623.615,10.000},
				{-24156.496,-3550.140,10.000},
				{-24504.096,-3475.997,10.000},
				{-24844.229,-3401.331,10.000},
				{-25176.860,-3326.313,10.000},
				{-25501.973,-3251.132,10.000},
				{-25819.573,-3176.000,10.000},
				{-26129.688,-3101.152,10.000},
				{-26432.373,-3026.848,10.000},
				{-26727.710,-2953.368,10.000},
				{-27015.811,-2881.013,10.000},
				{-27296.822,-2810.106,10.000},
				{-27570.921,-2740.988,10.000},
				{-27838.322,-2674.017,10.000},
				{-28099.278,-2609.560,10.000},
				{-28354.078,-2547.997,10.000},
				{-28603.049,-2489.709,10.000},
				{-28846.557,-2435.078,10.000},
				{-29085.005,-2384.480,10.000},
				{-29318.833,-2338.279,10.000},
				{-29548.515,-2296.820,10.000},
				{-29774.557,-2260.423,10.000},
				{-29997.495,-2229.379,10.000},
				{-30217.889,-2203.943,10.000},
				{-30436.322,-2184.327,10.000},
				{-30653.391,-2170.698,10.000},
				{-30869.709,-2163.173,10.000},
				{-31085.891,-2161.818,10.000},
				{-31302.555,-2166.642,10.000},
				{-31520.315,-2177.604,10.000},
				{-31739.776,-2194.607,10.000},
				{-31961.526,-2217.504,10.000},
				{-32186.136,-2246.100,10.000},
				{-32414.152,-2280.157,10.000},
				{-32646.092,-2319.398,10.000},
				{-32882.443,-2363.511,10.000},
				{-33123.659,-2412.159,10.000},
				{-33370.157,-2464.984,10.000},
				{-33622.319,-2521.613,10.000},
				{-33880.485,-2581.662,10.000},
				{-34144.959,-2644.747,10.000},
				{-34416.008,-2710.483,10.000},
				{-34693.857,-2778.496,10.000},
				{-34978.699,-2848.418,10.000},
				{-35270.689,-2919.898,10.000},
				{-35569.949,-2992.604,10.000},
				{-35876.571,-3066.220,10.000},
				{-36190.617,-3140.453,10.000},
				{-36512.120,-3215.032,10.000},
				{-36841.091,-3289.708,10.000},
				{-37177.516,-3364.255,10.000},
				{-37521.363,-3438.471,10.000},
				{-37872.581,-3512.173,10.000},
				{-38231.101,-3585.203,10.000},
				{-38596.843,-3657.420,10.000},
				{-38969.713,-3728.703,10.000},
				{-39349.608,-3798.950,10.000},
				{-39736.416,-3868.075,10.000},
				{-40130.016,-3936.006,10.000},
				{-40530.285,-4002.686,10.000},
				{-40937.092,-4068.072,10.000},
				{-41350.305,-4132.129,10.000},
				{-41769.789,-4194.835,10.000},
				{-42195.406,-4256.178,10.000},
				{-42627.021,-4316.150,10.000},
				{-43064.497,-4374.755,10.000},
				{-43507.697,-4431.999,10.000},
				{-43956.486,-4487.896,10.000},
				{-44410.733,-4542.464,10.000},
				{-44870.305,-4595.724,10.000},
				{-45335.075,-4647.703,10.000},
				{-45804.918,-4698.428,10.000},
				{-46279.711,-4747.929,10.000},
				{-46759.335,-4796.239,10.000},
				{-47243.674,-4843.391,10.000},
				{-47732.616,-4889.421,10.000},
				{-48226.052,-4934.363,10.000},
				{-48723.878,-4978.256,10.000},
				{-49225.991,-5021.135,10.000},
				{-49732.295,-5063.038,10.000},
				{-50242.695,-5104.001,10.000},
				{-50757.102,-5144.062,10.000},
				{-51275.427,-5183.258,10.000},
				{-51797.590,-5221.624,10.000},
				{-52323.510,-5259.198,10.000},
				{-52853.111,-5296.014,10.000},
				{-53386.322,-5332.109,10.000},
				{-53923.073,-5367.516,10.000},
				{-54463.300,-5402.269,10.000},
				{-55006.941,-5436.403,10.000},
				{-55553.936,-5469.950,10.000},
				{-56104.230,-5502.943,10.000},
				{-56657.771,-5535.413,10.000},
				{-57214.511,-5567.392,10.000},
				{-57774.402,-5598.910,10.000},
				{-58337.401,-5629.998,10.000},
				{-58903.470,-5660.685,10.000},
				{-59472.570,-5690.999,10.000},
				{-60044.667,-5720.971,10.000},
				{-60619.730,-5750.628,10.000},
				{-61197.730,-5779.998,10.000},
				{-61778.640,-5809.108,10.000},
				{-62362.439,-5837.986,10.000},
				{-62949.105,-5866.658,10.000},
				{-63538.620,-5895.150,10.000},
				{-64130.969,-5923.489,10.000},
				{-64726.139,-5951.701,10.000},
				{-65324.120,-5979.812,10.000},
				{-65924.905,-6007.848,10.000},
				{-66528.488,-6035.833,10.000},
				{-67134.868,-6063.794,10.000},
				{-67744.043,-6091.756,10.000},
				{-68356.018,-6119.745,10.000},
				{-68970.796,-6147.785,10.000},
				{-69588.387,-6175.903,10.000},
				{-70208.799,-6204.125,10.000},
				{-70832.047,-6232.476,10.000},
				{-71458.145,-6260.982,10.000},
				{-72087.112,-6289.669,10.000},
				{-72718.968,-6318.564,10.000},
				{-73353.737,-6347.694,10.000},
				{-73991.446,-6377.086,10.000},
				{-74632.123,-6406.768,10.000},
				{-75275.799,-6436.766,10.000},
				{-75922.510,-6467.110,10.000},
				{-76572.293,-6497.828,10.000},
				{-77225.188,-6528.949,10.000},
				{-77881.238,-6560.503,10.000},
				{-78540.490,-6592.520,10.000},
				{-79202.993,-6625.031,10.000},
				{-79868.800,-6658.067,10.000},
				{-80537.966,-6691.660,10.000},
				{-81210.551,-6725.843,10.000},
				{-81886.615,-6760.648,10.000},
				{-82566.226,-6796.109,10.000},
				{-83249.452,-6832.260,10.000},
				{-83936.366,-6869.136,10.000},
				{-84627.043,-6906.772,10.000},
				{-85321.563,-6945.204,10.000},
				{-86020.010,-6984.467,10.000},
				{-86722.470,-7024.599,10.000},
				{-87429.034,-7065.637,10.000},
				{-88139.795,-7107.616,10.000},
				{-88854.853,-7150.575,10.000},
				{-89574.308,-7194.551,10.000},
				{-90298.266,-7239.580,10.000},
				{-91026.836,-7285.698,10.000},
				{-91760.130,-7332.942,10.000},
				{-92498.264,-7381.345,10.000},
				{-93241.359,-7430.943,10.000},
				{-93989.535,-7481.767,10.000},
				{-94742.920,-7533.847,10.000},
				{-95501.641,-7587.211,10.000},
				{-96265.830,-7641.884,10.000},
				{-97035.618,-7697.888,10.000},
				{-97811.142,-7755.240,10.000},
				{-98592.538,-7813.953,10.000},
				{-99379.941,-7874.034,10.000},
				{-100173.490,-7935.485,10.000},
				{-100973.320,-7998.299,10.000},
				{-101779.566,-8062.462,10.000},
				{-102592.361,-8127.951,10.000},
				{-103411.834,-8194.731,10.000},
				{-104238.110,-8262.758,10.000},
				{-105071.307,-8331.973,10.000},
				{-105911.537,-8402.304,10.000},
				{-106758.904,-8473.663,10.000},
				{-107613.498,-8545.946,10.000},
				{-108475.401,-8619.031,10.000},
				{-109344.679,-8692.777,10.000},
				{-110221.381,-8767.022,10.000},
				{-111105.540,-8841.583,10.000},
				{-111997.165,-8916.254,10.000},
				{-112896.246,-8990.809,10.000},
				{-113802.746,-9064.997,10.000},
				{-114716.600,-9138.545,10.000},
				{-115637.716,-9211.157,10.000},
				{-116565.968,-9282.518,10.000},
				{-117501.197,-9352.293,10.000},
				{-118443.210,-9420.128,10.000},
				{-119391.776,-9485.658,10.000},
				{-120346.626,-9548.505,10.000},
				{-121307.455,-9608.285,10.000},
				{-122273.916,-9664.613,10.000},
				{-123245.627,-9717.108,10.000},
				{-124222.166,-9765.396,10.000},
				{-125203.078,-9809.121,10.000},
				{-126187.873,-9847.948,10.000},
				{-127176.030,-9881.567,10.000},
				{-128167.000,-9909.706,10.000},
				{-129160.213,-9932.128,10.000},
				{-130155.077,-9948.643,10.000},
				{-131150.988,-9959.107,10.000},
				{-132147.331,-9963.430,10.000},
				{-133143.488,-9961.572,10.000},
				{-134138.843,-9953.548,10.000},
				{-135132.786,-9939.429,10.000},
				{-136124.719,-9919.334,10.000},
				{-137114.063,-9893.436,10.000},
				{-138100.258,-9861.950,10.000},
				{-139082.771,-9825.133,10.000},
				{-140061.099,-9783.280,10.000},
				{-141034.770,-9736.712,10.000},
				{-142003.348,-9685.777,10.000},
				{-142966.432,-9630.840,10.000},
				{-143923.660,-9572.276,10.000},
				{-144874.707,-9510.468,10.000},
				{-145819.286,-9445.799,10.000},
				{-146757.151,-9378.644,10.000},
				{-147688.088,-9309.374,10.000},
				{-148611.923,-9238.343,10.000},
				{-149528.512,-9165.890,10.000},
				{-150437.745,-9092.337,10.000},
				{-151339.544,-9017.984,10.000},
				{-152233.855,-8943.110,10.000},
				{-153120.652,-8867.970,10.000},
				{-153999.932,-8792.800,10.000},
				{-154871.712,-8717.808,10.000},
				{-155736.031,-8643.184,10.000},
				{-156592.940,-8569.094,10.000},
				{-157442.509,-8495.684,10.000},
				{-158284.817,-8423.081,10.000},
				{-159119.956,-8351.391,10.000},
				{-159948.027,-8280.705,10.000},
				{-160769.136,-8211.099,10.000},
				{-161583.399,-8142.630,10.000},
				{-162390.934,-8075.346,10.000},
				{-163191.862,-8009.280,10.000},
				{-163986.308,-7944.456,10.000},
				{-164774.396,-7880.887,10.000},
				{-165556.254,-7818.577,10.000},
				{-166332.006,-7757.523,10.000},
				{-167101.778,-7697.715,10.000},
				{-167865.691,-7639.135,10.000},
				{-168623.868,-7581.762,10.000},
				{-169376.425,-7525.571,10.000},
				{-170123.478,-7470.529,10.000},
				{-170865.138,-7416.604,10.000},
				{-171601.514,-7363.759,10.000},
				{-172332.709,-7311.953,10.000},
				{-173058.767,-7260.576,10.000},
				{-173779.030,-7202.634,10.000},
				{-174492.223,-7131.932,10.000},
				{-175197.102,-7048.784,10.000},
				{-175892.450,-6953.484,10.000},
				{-176577.081,-6846.311,10.000},
				{-177249.834,-6727.522,10.000},
				{-177909.569,-6597.359,10.000},
				{-178555.174,-6456.046,10.000},
				{-179185.554,-6303.794,10.000},
				{-179799.633,-6140.796,10.000},
				{-180396.356,-5967.233,10.000},
				{-180974.736,-5783.799,10.000},
				{-181534.447,-5597.110,10.000},
				{-182075.755,-5413.080,10.000},
				{-182598.914,-5231.585,10.000},
				{-183104.165,-5052.510,10.000},
				{-183591.740,-4875.749,10.000},
				{-184061.860,-4701.199,10.000},
				{-184514.736,-4528.769,10.000},
				{-184950.573,-4358.369,10.000},
				{-185369.565,-4189.915,10.000},
				{-185771.898,-4023.329,10.000},
				{-186157.751,-3858.535,10.000},
				{-186527.297,-3695.461,10.000},
				{-186880.701,-3534.036,10.000},
				{-187218.120,-3374.195,10.000},
				{-187539.708,-3215.872,10.000},
				{-187845.608,-3059.002,10.000},
				{-188135.960,-2903.522,10.000},
				{-188410.897,-2749.371,10.000},
				{-188670.546,-2596.486,10.000},
				{-188915.026,-2444.807,10.000},
				{-189144.453,-2294.270,10.000},
				{-189358.935,-2144.815,10.000},
				{-189558.573,-1996.379,10.000},
				{-189743.463,-1848.898,10.000},
				{-189913.694,-1702.310,10.000},
				{-190069.348,-1556.549,10.000},
				{-190210.504,-1411.551,10.000},
				{-190337.229,-1267.249,10.000},
				{-190449.586,-1123.576,10.000},
				{-190547.633,-980.464,10.000},
				{-190631.465,-838.324,10.000},
				{-190701.762,-702.974,10.000},
				{-190759.736,-579.736,10.000},
				{-190806.588,-468.520,10.000},
				{-190843.513,-369.252,10.000},
				{-190871.700,-281.872,10.000},
				{-190892.334,-206.336,10.000},
				{-190906.595,-142.608,10.000},
				{-190915.661,-90.664,10.000},
				{-190920.710,-50.486,10.000},
				{-190922.916,-22.066,10.000},
				{-190923.456,-5.397,10.000},
				{-190923.456,-0.000,10.000}
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