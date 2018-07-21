package org.spectrum3847.paths;

import org.spectrum3847.lib.drivers.SrxMotionProfile;
import org.spectrum3847.lib.drivers.SrxTrajectory;

public class LeftSwitchCenter6 extends SrxTrajectory{
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (0.00,0.00,0.00)
	// (6.25,4.50,5.00)
	
	public LeftSwitchCenter6() {
		this(false);
	}
			
    public LeftSwitchCenter6(boolean flipped) {
		super();
		
		double[][] leftPoints = {
				{-0.598,-11.951,10.000},
				{-2.988,-23.904,10.000},
				{-8.367,-53.786,10.000},
				{-17.930,-95.630,10.000},
				{-32.874,-149.449,10.000},
				{-54.401,-215.263,10.000},
				{-83.711,-293.105,10.000},
				{-122.013,-383.018,10.000},
				{-170.519,-485.061,10.000},
				{-230.450,-599.309,10.000},
				{-303.035,-725.853,10.000},
				{-389.516,-864.807,10.000},
				{-491.146,-1016.305,10.000},
				{-609.197,-1180.504,10.000},
				{-744.956,-1357.587,10.000},
				{-899.127,-1541.709,10.000},
				{-1071.825,-1726.982,10.000},
				{-1263.178,-1913.531,10.000},
				{-1473.326,-2101.481,10.000},
				{-1702.421,-2290.953,10.000},
				{-1950.628,-2482.068,10.000},
				{-2218.122,-2674.941,10.000},
				{-2505.091,-2869.687,10.000},
				{-2811.733,-3066.421,10.000},
				{-3138.258,-3265.254,10.000},
				{-3484.888,-3466.295,10.000},
				{-3851.853,-3669.657,10.000},
				{-4239.398,-3875.448,10.000},
				{-4647.776,-4083.781,10.000},
				{-5077.253,-4294.765,10.000},
				{-5528.105,-4508.517,10.000},
				{-6000.620,-4725.151,10.000},
				{-6495.099,-4944.790,10.000},
				{-7011.854,-5167.556,10.000},
				{-7551.212,-5393.579,10.000},
				{-8113.512,-5622.996,10.000},
				{-8699.107,-5855.949,10.000},
				{-9308.365,-6092.587,10.000},
				{-9941.672,-6333.070,10.000},
				{-10599.429,-6577.567,10.000},
				{-11282.054,-6826.254,10.000},
				{-11989.987,-7079.321,10.000},
				{-12723.683,-7336.968,10.000},
				{-13483.624,-7599.406,10.000},
				{-14270.310,-7866.856,10.000},
				{-15084.265,-8139.553,10.000},
				{-15926.039,-8417.739,10.000},
				{-16796.205,-8701.666,10.000},
				{-17695.365,-8991.592,10.000},
				{-18624.143,-9287.781,10.000},
				{-19583.192,-9590.493,10.000},
				{-20573.190,-9899.986,10.000},
				{-21594.841,-10216.503,10.000},
				{-22648.868,-10540.269,10.000},
				{-23736.015,-10871.476,10.000},
				{-24857.042,-11210.271,10.000},
				{-26012.717,-11556.741,10.000},
				{-27203.806,-11910.892,10.000},
				{-28431.069,-12272.629,10.000},
				{-29695.241,-12641.725,10.000},
				{-30997.021,-13017.796,10.000},
				{-32337.048,-13400.268,10.000},
				{-33715.049,-13780.016,10.000},
				{-35129.772,-14147.230,10.000},
				{-36579.762,-14499.897,10.000},
				{-38063.336,-14835.743,10.000},
				{-39578.562,-15152.253,10.000},
				{-41123.233,-15446.716,10.000},
				{-42694.862,-15716.288,10.000},
				{-44290.670,-15958.077,10.000},
				{-45907.594,-16169.243,10.000},
				{-47542.306,-16347.121,10.000},
				{-49191.240,-16489.338,10.000},
				{-50850.633,-16593.935,10.000},
				{-52516.581,-16659.479,10.000},
				{-54185.095,-16685.137,10.000},
				{-55852.168,-16670.732,10.000},
				{-57514.736,-16625.674,10.000},
				{-59170.716,-16559.807,10.000},
				{-60818.153,-16474.363,10.000},
				{-62455.241,-16370.880,10.000},
				{-64080.354,-16251.132,10.000},
				{-65692.060,-16117.057,10.000},
				{-67289.128,-15970.680,10.000},
				{-68870.532,-15814.042,10.000},
				{-70435.446,-15649.143,10.000},
				{-71983.235,-15477.886,10.000},
				{-73513.439,-15302.040,10.000},
				{-75025.760,-15123.215,10.000},
				{-76520.044,-14942.839,10.000},
				{-77996.260,-14762.160,10.000},
				{-79454.484,-14582.237,10.000},
				{-80894.879,-14403.954,10.000},
				{-82317.682,-14228.028,10.000},
				{-83723.184,-14055.022,10.000},
				{-85111.720,-13885.363,10.000},
				{-86483.656,-13719.355,10.000},
				{-87839.376,-13557.198,10.000},
				{-89179.276,-13398.999,10.000},
				{-90503.755,-13244.789,10.000},
				{-91813.208,-13094.537,10.000},
				{-93108.023,-12948.153,10.000},
				{-94388.574,-12805.510,10.000},
				{-95655.218,-12666.440,10.000},
				{-96908.294,-12530.752,10.000},
				{-98148.117,-12398.230,10.000},
				{-99374.981,-12268.642,10.000},
				{-100589.155,-12141.744,10.000},
				{-101790.883,-12017.281,10.000},
				{-102980.383,-11894.994,10.000},
				{-104157.844,-11774.617,10.000},
				{-105323.433,-11655.881,10.000},
				{-106477.284,-11538.517,10.000},
				{-107619.510,-11422.253,10.000},
				{-108750.191,-11306.819,10.000},
				{-109869.386,-11191.943,10.000},
				{-110977.121,-11077.355,10.000},
				{-112073.400,-10962.788,10.000},
				{-113158.197,-10847.972,10.000},
				{-114231.462,-10732.643,10.000},
				{-115293.115,-10616.535,10.000},
				{-116343.054,-10499.389,10.000},
				{-117381.148,-10380.944,10.000},
				{-118407.243,-10260.948,10.000},
				{-119421.158,-10139.150,10.000},
				{-120422.689,-10015.310,10.000},
				{-121411.609,-9889.193,10.000},
				{-122387.666,-9760.578,10.000},
				{-123350.592,-9629.256,10.000},
				{-124300.096,-9495.038,10.000},
				{-125235.871,-9357.757,10.000},
				{-126157.599,-9217.273,10.000},
				{-127064.947,-9073.483,10.000},
				{-127957.579,-8926.322,10.000},
				{-128835.157,-8775.779,10.000},
				{-129697.347,-8621.901,10.000},
				{-130543.828,-8464.805,10.000},
				{-131374.297,-8304.691,10.000},
				{-132188.482,-8141.854,10.000},
				{-132986.152,-7976.698,10.000},
				{-133767.126,-7809.745,10.000},
				{-134531.292,-7641.652,10.000},
				{-135278.614,-7473.221,10.000},
				{-136009.154,-7305.405,10.000},
				{-136723.086,-7139.317,10.000},
				{-137420.709,-6976.226,10.000},
				{-138102.464,-6817.552,10.000},
				{-138768.949,-6664.857,10.000},
				{-139420.931,-6519.813,10.000},
				{-140059.349,-6384.180,10.000},
				{-140685.325,-6259.758,10.000},
				{-141300.159,-6148.339,10.000},
				{-141905.098,-6049.397,10.000},
				{-142501.243,-5961.451,10.000},
				{-143089.755,-5885.114,10.000},
				{-143671.910,-5821.553,10.000},
				{-144249.051,-5771.412,10.000},
				{-144822.530,-5734.783,10.000},
				{-145393.649,-5711.198,10.000},
				{-145963.615,-5699.655,10.000},
				{-146533.482,-5698.667,10.000},
				{-147104.116,-5706.347,10.000},
				{-147676.166,-5720.493,10.000},
				{-148250.035,-5738.690,10.000},
				{-148825.876,-5758.410,10.000},
				{-149403.586,-5777.105,10.000},
				{-149982.814,-5792.283,10.000},
				{-150563.226,-5804.114,10.000},
				{-151144.658,-5814.323,10.000},
				{-151726.917,-5822.587,10.000},
				{-152309.693,-5827.762,10.000},
				{-152892.585,-5828.917,10.000},
				{-153475.116,-5825.314,10.000},
				{-154056.755,-5816.389,10.000},
				{-154636.927,-5801.725,10.000},
				{-155215.031,-5781.034,10.000},
				{-155790.444,-5754.132,10.000},
				{-156362.537,-5720.928,10.000},
				{-156930.677,-5681.397,10.000},
				{-157494.234,-5635.576,10.000},
				{-158052.588,-5583.542,10.000},
				{-158605.129,-5525.409,10.000},
				{-159151.261,-5461.314,10.000},
				{-159690.402,-5391.414,10.000},
				{-160221.989,-5315.874,10.000},
				{-160745.476,-5234.869,10.000},
				{-161260.334,-5148.576,10.000},
				{-161766.051,-5057.172,10.000},
				{-162262.134,-4960.833,10.000},
				{-162748.108,-4859.732,10.000},
				{-163223.511,-4754.036,10.000},
				{-163687.902,-4643.907,10.000},
				{-164140.852,-4529.504,10.000},
				{-164581.950,-4410.977,10.000},
				{-165010.797,-4288.475,10.000},
				{-165427.011,-4162.140,10.000},
				{-165830.222,-4032.108,10.000},
				{-166220.074,-3898.514,10.000},
				{-166596.223,-3761.489,10.000},
				{-166958.339,-3621.161,10.000},
				{-167306.104,-3477.656,10.000},
				{-167639.214,-3331.100,10.000},
				{-167957.376,-3181.619,10.000},
				{-168260.310,-3029.336,10.000},
				{-168547.747,-2874.378,10.000},
				{-168819.435,-2716.872,10.000},
				{-169075.130,-2556.949,10.000},
				{-169314.603,-2394.738,10.000},
				{-169537.641,-2230.375,10.000},
				{-169744.041,-2063.997,10.000},
				{-169933.615,-1895.744,10.000},
				{-170106.191,-1725.759,10.000},
				{-170261.610,-1554.191,10.000},
				{-170399.729,-1381.189,10.000},
				{-170520.833,-1211.040,10.000},
				{-170625.819,-1049.865,10.000},
				{-170715.786,-899.671,10.000},
				{-170791.852,-760.657,10.000},
				{-170855.151,-632.992,10.000},
				{-170906.834,-516.822,10.000},
				{-170948.060,-412.265,10.000},
				{-170980.002,-319.417,10.000},
				{-171003.837,-238.356,10.000},
				{-171020.751,-169.139,10.000},
				{-171031.932,-111.810,10.000},
				{-171038.572,-66.397,10.000},
				{-171041.864,-32.919,10.000},
				{-171043.002,-11.386,10.000},
				{-171043.183,-1.803,10.000},
				{-171043.183,-0.000,10.000}
		};
		
		double[][] rightPoints = {
				{-0.598,-11.951,10.000},
				{-2.988,-23.902,10.000},
				{-8.366,-53.777,10.000},
				{-17.925,-95.594,10.000},
				{-32.859,-149.338,10.000},
				{-54.358,-214.990,10.000},
				{-83.609,-292.517,10.000},
				{-121.797,-381.876,10.000},
				{-170.098,-483.008,10.000},
				{-229.682,-595.839,10.000},
				{-301.709,-720.275,10.000},
				{-387.330,-856.205,10.000},
				{-487.679,-1003.494,10.000},
				{-603.878,-1161.985,10.000},
				{-737.027,-1331.495,10.000},
				{-887.619,-1505.917,10.000},
				{-1055.538,-1679.189,10.000},
				{-1240.656,-1851.184,10.000},
				{-1442.834,-2021.778,10.000},
				{-1661.919,-2190.850,10.000},
				{-1897.747,-2358.280,10.000},
				{-2150.142,-2523.951,10.000},
				{-2418.917,-2687.748,10.000},
				{-2703.873,-2849.559,10.000},
				{-3004.800,-3009.271,10.000},
				{-3321.477,-3166.773,10.000},
				{-3653.673,-3321.956,10.000},
				{-4001.144,-3474.708,10.000},
				{-4363.636,-3624.921,10.000},
				{-4740.884,-3772.480,10.000},
				{-5132.611,-3917.273,10.000},
				{-5538.529,-4059.182,10.000},
				{-5958.338,-4198.088,10.000},
				{-6391.725,-4333.865,10.000},
				{-6838.363,-4466.386,10.000},
				{-7297.914,-4595.512,10.000},
				{-7770.025,-4721.103,10.000},
				{-8254.326,-4843.008,10.000},
				{-8750.432,-4961.068,10.000},
				{-9257.944,-5075.115,10.000},
				{-9776.441,-5184.970,10.000},
				{-10305.485,-5290.446,10.000},
				{-10844.619,-5391.341,10.000},
				{-11393.364,-5487.445,10.000},
				{-11951.218,-5578.535,10.000},
				{-12517.655,-5664.379,10.000},
				{-13092.129,-5744.734,10.000},
				{-13674.063,-5819.346,10.000},
				{-14262.859,-5887.958,10.000},
				{-14857.890,-5950.307,10.000},
				{-15458.503,-6006.131,10.000},
				{-16064.020,-6055.174,10.000},
				{-16673.739,-6097.190,10.000},
				{-17286.935,-6131.956,10.000},
				{-17902.863,-6159.279,10.000},
				{-18520.764,-6179.013,10.000},
				{-19139.871,-6191.069,10.000},
				{-19759.415,-6195.442,10.000},
				{-20378.638,-6192.226,10.000},
				{-20996.803,-6181.648,10.000},
				{-21613.212,-6164.092,10.000},
				{-22227.225,-6140.131,10.000},
				{-22837.919,-6106.940,10.000},
				{-23444.157,-6062.378,10.000},
				{-24045.002,-6008.457,10.000},
				{-24639.748,-5947.453,10.000},
				{-25227.936,-5881.882,10.000},
				{-25809.381,-5814.455,10.000},
				{-26384.183,-5748.017,10.000},
				{-26952.729,-5685.462,10.000},
				{-27515.692,-5629.630,10.000},
				{-28074.011,-5583.188,10.000},
				{-28628.862,-5548.510,10.000},
				{-29181.617,-5527.554,10.000},
				{-29733.793,-5521.757,10.000},
				{-30286.988,-5531.951,10.000},
				{-30842.819,-5558.312,10.000},
				{-31403.158,-5603.381,10.000},
				{-31970.084,-5669.264,10.000},
				{-32545.557,-5754.729,10.000},
				{-33131.381,-5858.237,10.000},
				{-33729.182,-5978.013,10.000},
				{-34340.394,-6112.119,10.000},
				{-34966.247,-6258.529,10.000},
				{-35607.767,-6415.201,10.000},
				{-36265.780,-6580.135,10.000},
				{-36940.923,-6751.427,10.000},
				{-37633.653,-6927.306,10.000},
				{-38344.270,-7106.165,10.000},
				{-39072.927,-7286.572,10.000},
				{-39819.655,-7467.282,10.000},
				{-40584.379,-7647.234,10.000},
				{-41366.933,-7825.544,10.000},
				{-42167.083,-8001.496,10.000},
				{-42984.535,-8174.526,10.000},
				{-43818.956,-8344.207,10.000},
				{-44669.980,-8510.235,10.000},
				{-45537.221,-8672.411,10.000},
				{-46420.283,-8830.627,10.000},
				{-47318.768,-8984.851,10.000},
				{-48232.280,-9135.118,10.000},
				{-49160.432,-9281.514,10.000},
				{-50102.849,-9424.169,10.000},
				{-51059.174,-9563.249,10.000},
				{-52029.068,-9698.947,10.000},
				{-53012.216,-9831.477,10.000},
				{-54008.323,-9961.072,10.000},
				{-55017.121,-10087.976,10.000},
				{-56038.365,-10212.444,10.000},
				{-57071.839,-10334.736,10.000},
				{-58117.350,-10455.117,10.000},
				{-59174.736,-10573.856,10.000},
				{-60243.858,-10691.223,10.000},
				{-61324.607,-10807.489,10.000},
				{-62416.900,-10922.924,10.000},
				{-63520.680,-11037.801,10.000},
				{-64635.919,-11152.388,10.000},
				{-65762.614,-11266.956,10.000},
				{-66900.791,-11381.770,10.000},
				{-68050.501,-11497.098,10.000},
				{-69211.821,-11613.203,10.000},
				{-70384.856,-11730.347,10.000},
				{-71569.735,-11848.787,10.000},
				{-72766.612,-11968.780,10.000},
				{-73975.670,-12090.572,10.000},
				{-75197.110,-12214.406,10.000},
				{-76431.162,-12340.517,10.000},
				{-77678.074,-12469.125,10.000},
				{-78938.118,-12600.438,10.000},
				{-80211.583,-12734.647,10.000},
				{-81498.775,-12871.917,10.000},
				{-82800.013,-13012.389,10.000},
				{-84115.630,-13156.167,10.000},
				{-85445.961,-13303.313,10.000},
				{-86791.345,-13453.840,10.000},
				{-88152.116,-13607.702,10.000},
				{-89528.594,-13764.780,10.000},
				{-90921.081,-13924.874,10.000},
				{-92329.850,-14087.689,10.000},
				{-93755.132,-14252.823,10.000},
				{-95197.107,-14419.751,10.000},
				{-96655.889,-14587.818,10.000},
				{-98131.511,-14756.222,10.000},
				{-99623.912,-14924.009,10.000},
				{-101132.919,-15090.068,10.000},
				{-102658.232,-15253.130,10.000},
				{-104199.409,-15411.773,10.000},
				{-105755.853,-15564.438,10.000},
				{-107326.798,-15709.452,10.000},
				{-108911.304,-15845.056,10.000},
				{-110508.249,-15969.451,10.000},
				{-112116.334,-16080.845,10.000},
				{-113733.476,-16171.421,10.000},
				{-115356.547,-16230.711,10.000},
				{-116981.996,-16254.493,10.000},
				{-118606.157,-16241.605,10.000},
				{-120225.297,-16191.399,10.000},
				{-121835.675,-16103.785,10.000},
				{-123433.598,-15979.230,10.000},
				{-125015.472,-15818.736,10.000},
				{-126577.851,-15623.789,10.000},
				{-128117.478,-15396.275,10.000},
				{-129631.318,-15138.396,10.000},
				{-131116.574,-14852.564,10.000},
				{-132570.705,-14541.308,10.000},
				{-133991.422,-14207.175,10.000},
				{-135376.688,-13852.654,10.000},
				{-136725.280,-13485.921,10.000},
				{-138037.000,-13117.200,10.000},
				{-139312.042,-12750.422,10.000},
				{-140550.715,-12386.730,10.000},
				{-141753.421,-12027.056,10.000},
				{-142920.634,-11672.137,10.000},
				{-144052.888,-11322.538,10.000},
				{-145150.756,-10978.676,10.000},
				{-146214.840,-10640.839,10.000},
				{-147245.761,-10309.209,10.000},
				{-148244.149,-9983.882,10.000},
				{-149210.637,-9664.879,10.000},
				{-150145.853,-9352.165,10.000},
				{-151050.420,-9045.663,10.000},
				{-151924.945,-8745.259,10.000},
				{-152770.027,-8450.815,10.000},
				{-153586.245,-8162.177,10.000},
				{-154374.162,-7879.177,10.000},
				{-155134.326,-7601.642,10.000},
				{-155867.266,-7329.393,10.000},
				{-156573.491,-7062.256,10.000},
				{-157253.497,-6800.052,10.000},
				{-157907.758,-6542.611,10.000},
				{-158536.734,-6289.765,10.000},
				{-159140.869,-6041.351,10.000},
				{-159720.590,-5797.211,10.000},
				{-160276.310,-5557.194,10.000},
				{-160808.425,-5321.152,10.000},
				{-161317.319,-5088.944,10.000},
				{-161803.363,-4860.432,10.000},
				{-162266.911,-4635.482,10.000},
				{-162708.307,-4413.963,10.000},
				{-163127.882,-4195.747,10.000},
				{-163525.953,-3980.708,10.000},
				{-163902.825,-3768.720,10.000},
				{-164258.790,-3559.657,10.000},
				{-164594.130,-3353.396,10.000},
				{-164909.111,-3149.810,10.000},
				{-165203.988,-2948.771,10.000},
				{-165479.003,-2750.150,10.000},
				{-165734.385,-2553.817,10.000},
				{-165970.348,-2359.636,10.000},
				{-166187.095,-2167.470,10.000},
				{-166384.813,-1977.179,10.000},
				{-166563.675,-1788.619,10.000},
				{-166723.839,-1601.643,10.000},
				{-166865.449,-1416.101,10.000},
				{-166989.054,-1236.049,10.000},
				{-167095.786,-1067.321,10.000},
				{-167186.938,-911.514,10.000},
				{-167263.781,-768.431,10.000},
				{-167327.571,-637.900,10.000},
				{-167379.549,-519.779,10.000},
				{-167420.944,-413.947,10.000},
				{-167452.974,-320.309,10.000},
				{-167476.853,-238.787,10.000},
				{-167493.785,-169.324,10.000},
				{-167504.973,-111.876,10.000},
				{-167511.615,-66.415,10.000},
				{-167514.907,-32.922,10.000},
				{-167516.045,-11.386,10.000},
				{-167516.226,-1.803,10.000},
				{-167516.226,-0.000,10.000}
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