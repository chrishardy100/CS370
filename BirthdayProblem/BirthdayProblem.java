public class BirthdayProblem {
        
        public BirthdayProblem(int x){

        int people = x;
        double probability = 1;
        for (int i = 1; i < people; i++) {

            probability = 1 * (365.0 - i) / 365.0 * probability;
        }
        probability = 1 - probability;
        probability = probability * 100;
        System.out.println(probability);
        }

}
// int people = 47;
// double probPrime = 1.0;
// for (int i = 1; i <= people - 1; i++) {
// probPrime *= (365.0 - i) / 365.0;
// }
// System.out.println(1 - probPrime);