package com.huato.lottery;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Test {
    private static Random random = new Random();

    private final static double[] sigmas = {1d, 2d, 3d};

    private final static double DOUBLE_1 = 1d;

    private final static double DOUBLE_0 = 0d;

    public static void main(String[] args) {
        int size = 10000000;
        double mu = 2d;
        double sigmaValue = 1d;
        //标准差的切换
        double sigma = mu * sigmaValue;
        Map<Double, Double> map = installMap();
        for (int i = 0; i < size; i++) {
            double radomNo = getRandom(mu, sigma);
            if (radomNo > mu - sigma && radomNo <= mu + sigma) {
                map.put(sigmas[0], map.get(sigmas[0]) + DOUBLE_1);
            }
            if (radomNo > mu - 2 * sigma && radomNo <= mu + 2 * sigma) {
                map.put(sigmas[1], map.get(sigmas[1]) + DOUBLE_1);
            }
            if (radomNo > mu - 3 * sigma && radomNo <= mu + 3 * sigma) {
                map.put(sigmas[2], map.get(sigmas[2]) + DOUBLE_1);
            }
        }
        double mu1 = map.get(sigmas[0]);
        double mu2 = map.get(sigmas[1]);
        double mu3 = map.get(sigmas[2]);
        System.out.println("随机数出现在1个标注差内的概率为：" + mu1 / size);
        System.out.println("随机数出现在2个标注差内的概率为：" + mu2 / size);
        System.out.println("随机数出现在3个标注差内的概率为：" + mu3 / size);

    }

    private static double getRandom(double mu, double sigma) {
        return random.nextGaussian() * sigma + mu;
    }

    private static Map<Double, Double> installMap() {
        Map<Double, Double> map = new HashMap();
        map.put(sigmas[0], DOUBLE_0);
        map.put(sigmas[1], DOUBLE_0);
        map.put(sigmas[2], DOUBLE_0);
        return map;
    }
}
