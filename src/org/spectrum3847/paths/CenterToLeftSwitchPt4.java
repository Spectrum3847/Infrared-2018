package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class CenterToLeftSwitchPt4 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (-3.25,5.25,45.00)
	
	public CenterToLeftSwitchPt4() {
		this(false);
	}
			
    public CenterToLeftSwitchPt4(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{-0.594,-11.888,10.000},
				{-2.972,-23.775,10.000},
				{-8.321,-53.495,10.000},
				{-17.832,-95.106,10.000},
				{-32.693,-148.611,10.000},
				{-54.095,-214.017,10.000},
				{-83.228,-291.333,10.000},
				{-121.285,-380.572,10.000},
				{-169.460,-481.751,10.000},
				{-228.950,-594.893,10.000},
				{-300.952,-720.025,10.000},
				{-386.670,-857.180,10.000},
				{-487.310,-1006.398,10.000},
				{-604.082,-1167.725,10.000},
				{-738.204,-1341.214,10.000},
				{-890.896,-1526.925,10.000},
				{-1063.389,-1724.927,10.000},
				{-1256.321,-1929.319,10.000},
				{-1469.739,-2134.182,10.000},
				{-1703.695,-2339.558,10.000},
				{-1958.244,-2545.486,10.000},
				{-2233.444,-2752.000,10.000},
				{-2529.357,-2959.135,10.000},
				{-2846.049,-3166.919,10.000},
				{-3183.587,-3375.376,10.000},
				{-3542.039,-3584.529,10.000},
				{-3921.479,-3794.392,10.000},
				{-4321.977,-4004.978,10.000},
				{-4743.606,-4216.293,10.000},
				{-5186.439,-4428.337,10.000},
				{-5650.550,-4641.105,10.000},
				{-6136.008,-4854.586,10.000},
				{-6642.885,-5068.763,10.000},
				{-7171.246,-5283.613,10.000},
				{-7721.157,-5499.105,10.000},
				{-8292.677,-5715.204,10.000},
				{-8885.864,-5931.868,10.000},
				{-9500.768,-6149.046,10.000},
				{-10137.437,-6366.686,10.000},
				{-10795.910,-6584.726,10.000},
				{-11475.604,-6796.940,10.000},
				{-12175.309,-6997.057,10.000},
				{-12893.804,-7184.942,10.000},
				{-13629.850,-7360.466,10.000},
				{-14382.201,-7523.504,10.000},
				{-15149.595,-7673.941,10.000},
				{-15930.762,-7811.672,10.000},
				{-16724.422,-7936.600,10.000},
				{-17529.286,-8048.643,10.000},
				{-18344.059,-8147.731,10.000},
				{-19167.440,-8233.805,10.000},
				{-19998.122,-8306.821,10.000},
				{-20834.797,-8366.747,10.000},
				{-21676.153,-8413.563,10.000},
				{-22520.879,-8447.262,10.000},
				{-23367.664,-8467.848,10.000},
				{-24215.197,-8475.334,10.000},
				{-25062.795,-8475.976,10.000},
				{-25910.399,-8476.038,10.000},
				{-26757.954,-8475.550,10.000},
				{-27605.408,-8474.544,10.000},
				{-28452.713,-8473.050,10.000},
				{-29299.823,-8471.097,10.000},
				{-30146.694,-8468.712,10.000},
				{-30993.286,-8465.924,10.000},
				{-31839.562,-8462.756,10.000},
				{-32685.485,-8459.234,10.000},
				{-33531.023,-8455.381,10.000},
				{-34376.145,-8451.219,10.000},
				{-35220.822,-8446.769,10.000},
				{-36065.027,-8442.051,10.000},
				{-36908.736,-8437.084,10.000},
				{-37751.924,-8431.885,10.000},
				{-38594.571,-8426.472,10.000},
				{-39436.657,-8420.860,10.000},
				{-40278.164,-8415.064,10.000},
				{-41119.074,-8409.097,10.000},
				{-41959.371,-8402.972,10.000},
				{-42799.041,-8396.702,10.000},
				{-43638.071,-8390.296,10.000},
				{-44476.447,-8383.767,10.000},
				{-45314.159,-8377.122,10.000},
				{-46151.197,-8370.371,10.000},
				{-46987.549,-8363.521,10.000},
				{-47823.207,-8356.581,10.000},
				{-48658.162,-8349.556,10.000},
				{-49492.408,-8342.453,10.000},
				{-50325.936,-8335.277,10.000},
				{-51158.739,-8328.034,10.000},
				{-51990.811,-8320.726,10.000},
				{-52822.147,-8313.358,10.000},
				{-53652.741,-8305.934,10.000},
				{-54482.586,-8298.456,10.000},
				{-55311.679,-8290.927,10.000},
				{-56140.014,-8283.347,10.000},
				{-56967.586,-8275.720,10.000},
				{-57794.390,-8268.046,10.000},
				{-58620.423,-8260.326,10.000},
				{-59445.679,-8252.560,10.000},
				{-60270.154,-8244.747,10.000},
				{-61093.843,-8236.889,10.000},
				{-61916.741,-8228.984,10.000},
				{-62738.844,-8221.030,10.000},
				{-63560.147,-8213.028,10.000},
				{-64380.644,-8204.974,10.000},
				{-65200.331,-8196.867,10.000},
				{-66019.201,-8188.705,10.000},
				{-66837.250,-8180.486,10.000},
				{-67654.471,-8172.206,10.000},
				{-68470.857,-8163.861,10.000},
				{-69286.402,-8155.450,10.000},
				{-70101.099,-8146.968,10.000},
				{-70914.940,-8138.410,10.000},
				{-71727.917,-8129.774,10.000},
				{-72540.022,-8121.053,10.000},
				{-73351.246,-8112.242,10.000},
				{-74161.580,-8103.338,10.000},
				{-74971.013,-8094.333,10.000},
				{-75779.536,-8085.222,10.000},
				{-76587.136,-8075.999,10.000},
				{-77393.801,-8066.656,10.000},
				{-78199.520,-8057.187,10.000},
				{-79004.278,-8047.584,10.000},
				{-79808.062,-8037.839,10.000},
				{-80610.856,-8027.943,10.000},
				{-81412.645,-8017.888,10.000},
				{-82213.412,-8007.664,10.000},
				{-83013.138,-7997.262,10.000},
				{-83811.805,-7986.670,10.000},
				{-84609.393,-7975.877,10.000},
				{-85405.880,-7964.873,10.000},
				{-86201.244,-7953.643,10.000},
				{-86995.462,-7942.176,10.000},
				{-87788.507,-7930.457,10.000},
				{-88580.355,-7918.471,10.000},
				{-89370.975,-7906.202,10.000},
				{-90160.338,-7893.635,10.000},
				{-90948.413,-7880.750,10.000},
				{-91735.166,-7867.530,10.000},
				{-92520.562,-7853.954,10.000},
				{-93304.562,-7840.000,10.000},
				{-94087.126,-7825.647,10.000},
				{-94868.213,-7810.870,10.000},
				{-95647.778,-7795.643,10.000},
				{-96425.771,-7779.937,10.000},
				{-97202.144,-7763.725,10.000},
				{-97976.841,-7746.973,10.000},
				{-98749.806,-7729.649,10.000},
				{-99520.977,-7711.714,10.000},
				{-100290.291,-7693.131,10.000},
				{-101057.676,-7673.857,10.000},
				{-101823.061,-7653.846,10.000},
				{-102586.366,-7633.050,10.000},
				{-103347.508,-7611.416,10.000},
				{-104106.396,-7588.886,10.000},
				{-104862.936,-7565.399,10.000},
				{-105617.025,-7540.887,10.000},
				{-106368.553,-7515.278,10.000},
				{-107117.402,-7488.493,10.000},
				{-107863.446,-7460.445,10.000},
				{-108606.550,-7431.040,10.000},
				{-109346.568,-7400.177,10.000},
				{-110083.342,-7367.743,10.000},
				{-110816.704,-7333.615,10.000},
				{-111546.470,-7297.658,10.000},
				{-112272.442,-7259.725,10.000},
				{-112994.407,-7219.653,10.000},
				{-113712.134,-7177.260,10.000},
				{-114425.369,-7132.350,10.000},
				{-115133.839,-7084.702,10.000},
				{-115837.246,-7034.072,10.000},
				{-116535.265,-6980.188,10.000},
				{-117227.539,-6922.748,10.000},
				{-117913.681,-6861.415,10.000},
				{-118593.262,-6795.812,10.000},
				{-119265.814,-6725.515,10.000},
				{-119930.819,-6650.048,10.000},
				{-120587.706,-6568.876,10.000},
				{-121235.845,-6481.392,10.000},
				{-121874.537,-6386.913,10.000},
				{-122503.003,-6284.660,10.000},
				{-123120.378,-6173.749,10.000},
				{-123725.695,-6053.173,10.000},
				{-124317.873,-5921.778,10.000},
				{-124895.697,-5778.246,10.000},
				{-125457.803,-5621.061,10.000},
				{-126002.652,-5448.482,10.000},
				{-126528.502,-5258.502,10.000},
				{-127033.383,-5048.807,10.000},
				{-127515.055,-4816.728,10.000},
				{-127970.974,-4559.184,10.000},
				{-128398.237,-4272.629,10.000},
				{-128793.535,-3952.987,10.000},
				{-129153.096,-3595.603,10.000},
				{-129472.615,-3195.198,10.000},
				{-129747.203,-2745.872,10.000},
				{-129971.318,-2241.156,10.000},
				{-130138.737,-1674.184,10.000},
				{-130242.542,-1038.050,10.000},
				{-130275.186,-326.447,10.000},
				{-130321.716,-465.296,10.000},
				{-130455.560,-1338.436,10.000},
				{-130684.415,-2288.551,10.000},
				{-131014.639,-3302.241,10.000},
				{-131449.986,-4353.472,10.000},
				{-131990.011,-5400.255,10.000},
				{-132628.350,-6383.382,10.000},
				{-133351.300,-7229.503,10.000},
				{-134137.339,-7860.394,10.000},
				{-134958.145,-8208.055,10.000},
				{-135781.292,-8231.475,10.000},
				{-136574.114,-7928.215,10.000},
				{-137307.625,-7335.113,10.000},
				{-137959.400,-6517.752,10.000},
				{-138514.793,-5553.923,10.000},
				{-138966.600,-4518.073,10.000},
				{-139313.727,-3471.268,10.000},
				{-139559.475,-2457.477,10.000},
				{-139709.919,-1504.449,10.000},
				{-139772.608,-626.888,10.000},
				{-139789.597,-169.885,10.000},
				{-139878.250,-886.530,10.000},
				{-140030.991,-1527.410,10.000},
				{-140240.855,-2098.646,10.000},
				{-140501.563,-2607.078,10.000},
				{-140807.519,-3059.561,10.000},
				{-141153.778,-3462.590,10.000},
				{-141535.989,-3822.110,10.000},
				{-141950.334,-4143.447,10.000},
				{-142393.465,-4431.307,10.000},
				{-142862.446,-4689.813,10.000},
				{-143354.701,-4922.555,10.000},
				{-143867.967,-5132.653,10.000},
				{-144400.247,-5322.808,10.000},
				{-144949.784,-5495.364,10.000},
				{-145515.019,-5652.353,10.000},
				{-146094.573,-5795.537,10.000},
				{-146687.218,-5926.450,10.000},
				{-147291.861,-6046.428,10.000},
				{-147907.524,-6156.635,10.000},
				{-148533.333,-6258.091,10.000},
				{-149168.502,-6351.691,10.000},
				{-149812.324,-6438.219,10.000},
				{-150464.161,-6518.368,10.000},
				{-151123.436,-6592.748,10.000},
				{-151789.626,-6661.902,10.000},
				{-152462.257,-6726.309,10.000},
				{-153140.897,-6786.396,10.000},
				{-153825.151,-6842.544,10.000},
				{-154514.660,-6895.093,10.000},
				{-155209.095,-6944.347,10.000},
				{-155908.153,-6990.580,10.000},
				{-156611.557,-7034.036,10.000},
				{-157319.050,-7074.939,10.000},
				{-158030.399,-7113.486,10.000},
				{-158745.385,-7149.861,10.000},
				{-159463.807,-7184.224,10.000},
				{-160185.480,-7216.727,10.000},
				{-160910.231,-7247.503,10.000},
				{-161637.898,-7276.677,10.000},
				{-162368.334,-7304.360,10.000},
				{-163101.400,-7330.655,10.000},
				{-163836.965,-7355.656,10.000},
				{-164574.910,-7379.449,10.000},
				{-165315.121,-7402.114,10.000},
				{-166057.494,-7423.723,10.000},
				{-166801.928,-7444.343,10.000},
				{-167548.332,-7464.036,10.000},
				{-168296.617,-7482.859,10.000},
				{-169046.704,-7500.864,10.000},
				{-169798.514,-7518.101,10.000},
				{-170551.975,-7534.614,10.000},
				{-171307.020,-7550.446,10.000},
				{-172063.583,-7565.634,10.000},
				{-172821.605,-7580.216,10.000},
				{-173581.028,-7594.226,10.000},
				{-174341.797,-7607.693,10.000},
				{-175103.862,-7620.648,10.000},
				{-175867.174,-7633.118,10.000},
				{-176631.686,-7645.128,10.000},
				{-177397.357,-7656.703,10.000},
				{-178164.143,-7667.864,10.000},
				{-178932.007,-7678.633,10.000},
				{-179700.909,-7689.029,10.000},
				{-180470.816,-7699.071,10.000},
				{-181241.694,-7708.775,10.000},
				{-182013.510,-7718.159,10.000},
				{-182786.234,-7727.237,10.000},
				{-183559.836,-7736.024,10.000},
				{-184334.289,-7744.533,10.000},
				{-185109.567,-7752.778,10.000},
				{-185885.644,-7760.771,10.000},
				{-186662.496,-7768.522,10.000},
				{-187440.101,-7776.043,10.000},
				{-188218.435,-7783.343,10.000},
				{-188997.478,-7790.434,10.000},
				{-189777.211,-7797.323,10.000},
				{-190557.612,-7804.019,10.000},
				{-191338.666,-7810.531,10.000},
				{-192120.352,-7816.867,10.000},
				{-192902.656,-7823.033,10.000},
				{-193685.559,-7829.038,10.000},
				{-194469.048,-7834.887,10.000},
				{-195253.107,-7840.588,10.000},
				{-196037.721,-7846.145,10.000},
				{-196822.878,-7851.566,10.000},
				{-197608.564,-7856.855,10.000},
				{-198394.765,-7862.018,10.000},
				{-199181.472,-7867.060,10.000},
				{-199968.670,-7871.986,10.000},
				{-200756.350,-7876.799,10.000},
				{-201544.501,-7881.506,10.000},
				{-202333.112,-7886.109,10.000},
				{-203122.173,-7890.613,10.000},
				{-203911.675,-7895.022,10.000},
				{-204701.609,-7899.339,10.000},
				{-205491.966,-7903.569,10.000},
				{-206282.737,-7907.713,10.000},
				{-207073.915,-7911.777,10.000},
				{-207865.491,-7915.762,10.000},
				{-208657.458,-7919.672,10.000},
				{-209449.809,-7923.509,10.000},
				{-210242.537,-7927.277,10.000},
				{-211035.635,-7930.979,10.000},
				{-211829.096,-7934.616,10.000},
				{-212622.915,-7938.192,10.000},
				{-213417.086,-7941.708,10.000},
				{-214211.603,-7945.167,10.000},
				{-215006.460,-7948.572,10.000},
				{-215801.652,-7951.924,10.000},
				{-216597.175,-7955.226,10.000},
				{-217393.023,-7958.479,10.000},
				{-218189.192,-7961.687,10.000},
				{-218985.677,-7964.849,10.000},
				{-219782.474,-7967.970,10.000},
				{-220579.578,-7971.049,10.000},
				{-221376.987,-7974.090,10.000},
				{-222174.697,-7977.093,10.000},
				{-222972.703,-7980.061,10.000},
				{-223771.002,-7982.995,10.000},
				{-224569.592,-7985.897,10.000},
				{-225368.469,-7988.768,10.000},
				{-226167.630,-7991.610,10.000},
				{-226967.072,-7994.424,10.000},
				{-227766.793,-7997.211,10.000},
				{-228566.791,-7999.974,10.000},
				{-229367.062,-8002.714,10.000},
				{-230167.605,-8005.431,10.000},
				{-230968.418,-8008.128,10.000},
				{-231769.303,-8008.852,10.000},
				{-232569.474,-8001.707,10.000},
				{-233367.749,-7982.747,10.000},
				{-234162.944,-7951.955,10.000},
				{-234953.876,-7909.320,10.000},
				{-235739.359,-7854.826,10.000},
				{-236518.205,-7788.463,10.000},
				{-237289.227,-7710.216,10.000},
				{-238051.234,-7620.075,10.000},
				{-238803.037,-7518.026,10.000},
				{-239543.443,-7404.059,10.000},
				{-240271.259,-7278.162,10.000},
				{-240985.291,-7140.325,10.000},
				{-241684.345,-6990.538,10.000},
				{-242367.225,-6828.792,10.000},
				{-243032.732,-6655.078,10.000},
				{-243679.671,-6469.387,10.000},
				{-244307.039,-6273.677,10.000},
				{-244914.425,-6073.863,10.000},
				{-245501.816,-5873.907,10.000},
				{-246069.197,-5673.812,10.000},
				{-246616.555,-5473.585,10.000},
				{-247143.878,-5273.230,10.000},
				{-247651.153,-5072.751,10.000},
				{-248138.369,-4872.153,10.000},
				{-248605.513,-4671.440,10.000},
				{-249052.575,-4470.618,10.000},
				{-249479.544,-4269.690,10.000},
				{-249886.410,-4068.661,10.000},
				{-250273.163,-3867.536,10.000},
				{-250639.795,-3666.319,10.000},
				{-250986.296,-3465.014,10.000},
				{-251312.659,-3263.627,10.000},
				{-251618.875,-3062.162,10.000},
				{-251904.938,-2860.623,10.000},
				{-252170.839,-2659.015,10.000},
				{-252416.574,-2457.343,10.000},
				{-252642.135,-2255.612,10.000},
				{-252847.517,-2053.825,10.000},
				{-253032.716,-1851.989,10.000},
				{-253197.924,-1652.078,10.000},
				{-253343.928,-1460.040,10.000},
				{-253471.913,-1279.853,10.000},
				{-253583.066,-1111.523,10.000},
				{-253678.571,-955.056,10.000},
				{-253759.617,-810.458,10.000},
				{-253827.390,-677.731,10.000},
				{-253883.078,-556.881,10.000},
				{-253927.869,-447.909,10.000},
				{-253962.951,-350.818,10.000},
				{-253989.512,-265.611,10.000},
				{-254008.741,-192.288,10.000},
				{-254021.826,-130.851,10.000},
				{-254029.956,-81.300,10.000},
				{-254034.320,-43.637,10.000},
				{-254036.106,-17.861,10.000},
				{-254036.503,-3.972,10.000},
				{-254036.503,-0.000,10.000}
		};
		
		double[][] rightPoints = {
				{-0.594,-11.888,10.000},
				{-2.972,-23.775,10.000},
				{-8.321,-53.493,10.000},
				{-17.831,-95.095,10.000},
				{-32.688,-148.578,10.000},
				{-54.082,-213.936,10.000},
				{-83.198,-291.158,10.000},
				{-121.221,-380.233,10.000},
				{-169.335,-481.142,10.000},
				{-228.722,-593.863,10.000},
				{-300.559,-718.370,10.000},
				{-386.021,-854.629,10.000},
				{-486.281,-1002.600,10.000},
				{-602.505,-1162.238,10.000},
				{-735.854,-1333.488,10.000},
				{-887.483,-1516.291,10.000},
				{-1058.541,-1710.579,10.000},
				{-1249.577,-1910.364,10.000},
				{-1460.545,-2109.678,10.000},
				{-1691.393,-2308.479,10.000},
				{-1942.066,-2506.729,10.000},
				{-2212.505,-2704.391,10.000},
				{-2502.649,-2901.434,10.000},
				{-2812.431,-3097.827,10.000},
				{-3141.786,-3293.547,10.000},
				{-3490.643,-3488.572,10.000},
				{-3858.932,-3682.885,10.000},
				{-4246.579,-3876.476,10.000},
				{-4653.513,-4069.339,10.000},
				{-5079.660,-4261.472,10.000},
				{-5524.949,-4452.882,10.000},
				{-5989.306,-4643.577,10.000},
				{-6472.664,-4833.577,10.000},
				{-6974.955,-5022.905,10.000},
				{-7496.113,-5211.589,10.000},
				{-8036.080,-5399.667,10.000},
				{-8594.798,-5587.181,10.000},
				{-9172.216,-5774.179,10.000},
				{-9768.288,-5960.717,10.000},
				{-10382.973,-6146.854,10.000},
				{-11015.666,-6326.929,10.000},
				{-11665.199,-6495.327,10.000},
				{-12330.417,-6652.181,10.000},
				{-13010.179,-6797.621,10.000},
				{-13703.356,-6931.772,10.000},
				{-14408.831,-7054.749,10.000},
				{-15125.497,-7166.657,10.000},
				{-15852.256,-7267.592,10.000},
				{-16588.020,-7357.637,10.000},
				{-17331.706,-7436.863,10.000},
				{-18082.239,-7505.327,10.000},
				{-18838.546,-7563.074,10.000},
				{-19599.560,-7610.136,10.000},
				{-20364.213,-7646.533,10.000},
				{-21131.440,-7672.271,10.000},
				{-21900.175,-7687.348,10.000},
				{-22669.350,-7691.750,10.000},
				{-23438.461,-7691.107,10.000},
				{-24207.565,-7691.046,10.000},
				{-24976.719,-7691.534,10.000},
				{-25745.973,-7692.540,10.000},
				{-26515.376,-7694.034,10.000},
				{-27284.975,-7695.987,10.000},
				{-28054.812,-7698.372,10.000},
				{-28824.928,-7701.160,10.000},
				{-29595.361,-7704.328,10.000},
				{-30366.146,-7707.850,10.000},
				{-31137.316,-7711.703,10.000},
				{-31908.903,-7715.866,10.000},
				{-32680.934,-7720.316,10.000},
				{-33453.438,-7725.033,10.000},
				{-34226.438,-7730.000,10.000},
				{-34999.958,-7735.199,10.000},
				{-35774.019,-7740.612,10.000},
				{-36548.641,-7746.224,10.000},
				{-37323.843,-7752.021,10.000},
				{-38099.642,-7757.988,10.000},
				{-38876.053,-7764.113,10.000},
				{-39653.092,-7770.383,10.000},
				{-40430.771,-7776.788,10.000},
				{-41209.102,-7783.318,10.000},
				{-41988.099,-7789.963,10.000},
				{-42767.770,-7796.714,10.000},
				{-43548.127,-7803.564,10.000},
				{-44329.177,-7810.504,10.000},
				{-45110.930,-7817.529,10.000},
				{-45893.393,-7824.632,10.000},
				{-46676.574,-7831.808,10.000},
				{-47460.479,-7839.052,10.000},
				{-48245.115,-7846.360,10.000},
				{-49030.488,-7853.727,10.000},
				{-49816.603,-7861.151,10.000},
				{-50603.466,-7868.630,10.000},
				{-51391.082,-7876.159,10.000},
				{-52179.455,-7883.738,10.000},
				{-52968.592,-7891.365,10.000},
				{-53758.496,-7899.040,10.000},
				{-54549.172,-7906.760,10.000},
				{-55340.625,-7914.526,10.000},
				{-56132.858,-7922.339,10.000},
				{-56925.878,-7930.197,10.000},
				{-57719.688,-7938.102,10.000},
				{-58514.294,-7946.056,10.000},
				{-59309.700,-7954.059,10.000},
				{-60105.911,-7962.112,10.000},
				{-60902.933,-7970.219,10.000},
				{-61700.771,-7978.381,10.000},
				{-62499.431,-7986.600,10.000},
				{-63298.919,-7994.881,10.000},
				{-64099.242,-8003.225,10.000},
				{-64900.405,-8011.636,10.000},
				{-65702.417,-8020.119,10.000},
				{-66505.285,-8028.676,10.000},
				{-67309.016,-8037.313,10.000},
				{-68113.619,-8046.034,10.000},
				{-68919.104,-8054.844,10.000},
				{-69725.479,-8063.749,10.000},
				{-70532.754,-8072.753,10.000},
				{-71340.941,-8081.864,10.000},
				{-72150.049,-8091.088,10.000},
				{-72960.092,-8100.430,10.000},
				{-73771.082,-8109.900,10.000},
				{-74583.033,-8119.503,10.000},
				{-75395.957,-8129.248,10.000},
				{-76209.872,-8139.143,10.000},
				{-77024.791,-8149.198,10.000},
				{-77840.734,-8159.422,10.000},
				{-78657.716,-8169.825,10.000},
				{-79475.758,-8180.416,10.000},
				{-80294.879,-8191.209,10.000},
				{-81115.100,-8202.213,10.000},
				{-81936.444,-8213.443,10.000},
				{-82758.935,-8224.910,10.000},
				{-83582.598,-8236.629,10.000},
				{-84407.460,-8248.615,10.000},
				{-85233.548,-8260.884,10.000},
				{-86060.893,-8273.451,10.000},
				{-86889.527,-8286.336,10.000},
				{-87719.482,-8299.556,10.000},
				{-88550.796,-8313.132,10.000},
				{-89383.504,-8327.085,10.000},
				{-90217.648,-8341.438,10.000},
				{-91053.269,-8356.215,10.000},
				{-91890.414,-8371.442,10.000},
				{-92729.128,-8387.147,10.000},
				{-93569.464,-8403.360,10.000},
				{-94411.476,-8420.111,10.000},
				{-95255.219,-8437.436,10.000},
				{-96100.756,-8455.370,10.000},
				{-96948.151,-8473.953,10.000},
				{-97797.474,-8493.227,10.000},
				{-98648.798,-8513.237,10.000},
				{-99502.201,-8534.033,10.000},
				{-100357.768,-8555.667,10.000},
				{-101215.587,-8578.196,10.000},
				{-102075.756,-8601.683,10.000},
				{-102938.375,-8626.195,10.000},
				{-103803.555,-8651.803,10.000},
				{-104671.414,-8678.588,10.000},
				{-105542.078,-8706.635,10.000},
				{-106415.682,-8736.039,10.000},
				{-107292.372,-8766.902,10.000},
				{-108172.305,-8799.335,10.000},
				{-109055.651,-8833.462,10.000},
				{-109942.593,-8869.418,10.000},
				{-110833.328,-8907.350,10.000},
				{-111728.070,-8947.422,10.000},
				{-112627.052,-8989.812,10.000},
				{-113530.524,-9034.721,10.000},
				{-114438.761,-9082.368,10.000},
				{-115352.060,-9132.997,10.000},
				{-116270.748,-9186.879,10.000},
				{-117195.180,-9244.316,10.000},
				{-118125.744,-9305.646,10.000},
				{-119062.869,-9371.247,10.000},
				{-120007.023,-9441.541,10.000},
				{-120958.724,-9517.004,10.000},
				{-121918.541,-9598.173,10.000},
				{-122887.106,-9685.652,10.000},
				{-123865.119,-9780.126,10.000},
				{-124853.356,-9882.373,10.000},
				{-125852.684,-9993.277,10.000},
				{-126864.068,-10113.846,10.000},
				{-127888.591,-10245.231,10.000},
				{-128927.467,-10388.753,10.000},
				{-129982.059,-10545.925,10.000},
				{-131053.908,-10718.490,10.000},
				{-132144.753,-10908.453,10.000},
				{-133256.566,-11118.128,10.000},
				{-134391.585,-11350.183,10.000},
				{-135552.354,-11607.698,10.000},
				{-136741.776,-11894.218,10.000},
				{-137963.158,-12213.818,10.000},
				{-139220.273,-12571.152,10.000},
				{-140517.422,-12971.495,10.000},
				{-141859.497,-13420.745,10.000},
				{-143252.034,-13925.368,10.000},
				{-144701.256,-14492.225,10.000},
				{-146214.078,-15128.220,10.000},
				{-147798.044,-15839.656,10.000},
				{-149461.161,-16631.168,10.000},
				{-151211.566,-17504.054,10.000},
				{-153056.952,-18453.859,10.000},
				{-155003.671,-19467.186,10.000},
				{-157055.471,-20518.004,10.000},
				{-159211.905,-21564.339,10.000},
				{-161466.606,-22547.013,10.000},
				{-163805.878,-23392.718,10.000},
				{-166208.206,-24023.284,10.000},
				{-168645.282,-24370.759,10.000},
				{-171084.699,-24394.167,10.000},
				{-173493.806,-24091.069,10.000},
				{-175843.634,-23498.275,10.000},
				{-178111.765,-22681.318,10.000},
				{-180283.559,-21717.939,10.000},
				{-182351.813,-20682.537,10.000},
				{-184315.428,-19636.149,10.000},
				{-186177.701,-18622.727,10.000},
				{-187944.702,-17670.015,10.000},
				{-189623.974,-16792.717,10.000},
				{-191223.592,-15996.187,10.000},
				{-192751.563,-15279.704,10.000},
				{-194215.460,-14638.969,10.000},
				{-195622.245,-14067.850,10.000},
				{-196978.196,-13559.514,10.000},
				{-198288.907,-13107.109,10.000},
				{-199559.322,-12704.144,10.000},
				{-200793.789,-12344.677,10.000},
				{-201996.128,-12023.384,10.000},
				{-203169.684,-11735.560,10.000},
				{-204317.392,-11477.084,10.000},
				{-205441.829,-11244.367,10.000},
				{-206545.258,-11034.290,10.000},
				{-207629.673,-10844.153,10.000},
				{-208696.834,-10671.612,10.000},
				{-209748.298,-10514.636,10.000},
				{-210785.444,-10371.463,10.000},
				{-211809.500,-10240.559,10.000},
				{-212821.559,-10120.590,10.000},
				{-213822.598,-10010.391,10.000},
				{-214813.492,-9908.940,10.000},
				{-215795.027,-9815.346,10.000},
				{-216767.909,-9728.823,10.000},
				{-217732.777,-9648.679,10.000},
				{-218690.207,-9574.301,10.000},
				{-219640.722,-9505.151,10.000},
				{-220584.797,-9440.747,10.000},
				{-221522.863,-9380.662,10.000},
				{-222455.315,-9324.517,10.000},
				{-223382.512,-9271.970,10.000},
				{-224304.784,-9222.718,10.000},
				{-225222.432,-9176.487,10.000},
				{-226135.736,-9133.032,10.000},
				{-227044.949,-9092.131,10.000},
				{-227950.307,-9053.584,10.000},
				{-228852.028,-9017.212,10.000},
				{-229750.313,-8982.849,10.000},
				{-230645.348,-8950.347,10.000},
				{-231537.305,-8919.572,10.000},
				{-232426.345,-8890.399,10.000},
				{-233312.617,-8862.717,10.000},
				{-234196.259,-8836.423,10.000},
				{-235077.401,-8811.422,10.000},
				{-235956.164,-8787.629,10.000},
				{-236832.660,-8764.965,10.000},
				{-237706.996,-8743.357,10.000},
				{-238579.270,-8722.737,10.000},
				{-239449.574,-8703.044,10.000},
				{-240317.996,-8684.222,10.000},
				{-241184.618,-8666.216,10.000},
				{-242049.516,-8648.980,10.000},
				{-242912.763,-8632.467,10.000},
				{-243774.426,-8616.636,10.000},
				{-244634.571,-8601.447,10.000},
				{-245493.258,-8586.866,10.000},
				{-246350.543,-8572.857,10.000},
				{-247206.482,-8559.390,10.000},
				{-248061.126,-8546.435,10.000},
				{-248914.522,-8533.965,10.000},
				{-249766.718,-8521.955,10.000},
				{-250617.756,-8510.381,10.000},
				{-251467.678,-8499.219,10.000},
				{-252316.523,-8488.451,10.000},
				{-253164.328,-8478.055,10.000},
				{-254011.130,-8468.013,10.000},
				{-254856.961,-8458.309,10.000},
				{-255701.853,-8448.926,10.000},
				{-256545.838,-8439.848,10.000},
				{-257388.944,-8431.061,10.000},
				{-258231.199,-8422.551,10.000},
				{-259072.630,-8414.306,10.000},
				{-259913.261,-8406.314,10.000},
				{-260753.117,-8398.563,10.000},
				{-261592.222,-8391.042,10.000},
				{-262430.596,-8383.742,10.000},
				{-263268.261,-8376.651,10.000},
				{-264105.237,-8369.762,10.000},
				{-264941.544,-8363.066,10.000},
				{-265777.199,-8356.554,10.000},
				{-266612.221,-8350.218,10.000},
				{-267446.626,-8344.052,10.000},
				{-268280.431,-8338.047,10.000},
				{-269113.651,-8332.198,10.000},
				{-269946.301,-8326.498,10.000},
				{-270778.394,-8320.940,10.000},
				{-271609.946,-8315.519,10.000},
				{-272440.969,-8310.230,10.000},
				{-273271.476,-8305.067,10.000},
				{-274101.479,-8300.025,10.000},
				{-274930.989,-8295.100,10.000},
				{-275760.017,-8290.286,10.000},
				{-276588.575,-8285.580,10.000},
				{-277416.673,-8280.977,10.000},
				{-278244.320,-8276.473,10.000},
				{-279071.527,-8272.064,10.000},
				{-279898.301,-8267.747,10.000},
				{-280724.653,-8263.517,10.000},
				{-281550.590,-8259.373,10.000},
				{-282376.121,-8255.309,10.000},
				{-283201.254,-8251.324,10.000},
				{-284025.995,-8247.414,10.000},
				{-284850.353,-8243.577,10.000},
				{-285674.334,-8239.809,10.000},
				{-286497.944,-8236.107,10.000},
				{-287321.191,-8232.470,10.000},
				{-288144.081,-8228.895,10.000},
				{-288966.619,-8225.378,10.000},
				{-289788.811,-8221.919,10.000},
				{-290610.662,-8218.514,10.000},
				{-291432.178,-8215.162,10.000},
				{-292253.364,-8211.860,10.000},
				{-293074.225,-8208.607,10.000},
				{-293894.765,-8205.400,10.000},
				{-294714.989,-8202.237,10.000},
				{-295534.900,-8199.116,10.000},
				{-296354.504,-8196.037,10.000},
				{-297173.804,-8192.996,10.000},
				{-297992.803,-8189.993,10.000},
				{-298811.505,-8187.025,10.000},
				{-299629.915,-8184.091,10.000},
				{-300448.033,-8181.189,10.000},
				{-301265.865,-8178.318,10.000},
				{-302083.413,-8175.477,10.000},
				{-302900.679,-8172.663,10.000},
				{-303717.667,-8169.875,10.000},
				{-304534.378,-8167.112,10.000},
				{-305350.815,-8164.372,10.000},
				{-306166.981,-8161.655,10.000},
				{-306982.876,-8158.958,10.000},
				{-307798.306,-8154.292,10.000},
				{-308612.472,-8141.663,10.000},
				{-309424.179,-8117.076,10.000},
				{-310232.234,-8080.544,10.000},
				{-311035.442,-8032.081,10.000},
				{-311832.612,-7971.700,10.000},
				{-312622.553,-7899.415,10.000},
				{-313404.077,-7815.238,10.000},
				{-314175.995,-7719.180,10.000},
				{-314937.121,-7611.255,10.000},
				{-315686.268,-7491.473,10.000},
				{-316422.253,-7359.845,10.000},
				{-317143.891,-7216.383,10.000},
				{-317850.000,-7061.095,10.000},
				{-318539.399,-6893.991,10.000},
				{-319210.907,-6715.080,10.000},
				{-319863.345,-6524.371,10.000},
				{-320495.729,-6323.849,10.000},
				{-321107.678,-6119.486,10.000},
				{-321699.205,-5915.265,10.000},
				{-322270.323,-5711.182,10.000},
				{-322821.046,-5507.232,10.000},
				{-323351.387,-5303.410,10.000},
				{-323861.358,-5099.712,10.000},
				{-324350.971,-4896.133,10.000},
				{-324820.238,-4692.668,10.000},
				{-325269.170,-4489.314,10.000},
				{-325697.776,-4286.065,10.000},
				{-326106.068,-4082.916,10.000},
				{-326494.054,-3879.864,10.000},
				{-326861.745,-3676.904,10.000},
				{-327209.148,-3474.031,10.000},
				{-327536.272,-3271.241,10.000},
				{-327843.125,-3068.529,10.000},
				{-328129.714,-2865.891,10.000},
				{-328396.046,-2663.322,10.000},
				{-328642.128,-2460.817,10.000},
				{-328867.965,-2258.371,10.000},
				{-329073.563,-2055.980,10.000},
				{-329258.927,-1853.639,10.000},
				{-329424.258,-1653.316,10.000},
				{-329570.353,-1460.950,10.000},
				{-329698.404,-1280.508,10.000},
				{-329809.603,-1111.984,10.000},
				{-329905.140,-955.372,10.000},
				{-329986.207,-810.667,10.000},
				{-330053.993,-677.865,10.000},
				{-330109.689,-556.963,10.000},
				{-330154.485,-447.957,10.000},
				{-330189.569,-350.844,10.000},
				{-330216.132,-265.624,10.000},
				{-330235.361,-192.294,10.000},
				{-330248.446,-130.853,10.000},
				{-330256.577,-81.301,10.000},
				{-330260.940,-43.637,10.000},
				{-330262.726,-17.861,10.000},
				{-330263.124,-3.972,10.000},
				{-330263.124,-0.000,10.000}
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