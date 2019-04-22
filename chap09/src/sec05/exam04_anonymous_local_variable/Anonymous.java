package sec05.exam04_anonymous_local_variable;

public class Anonymous {
        private int field;

        public void method(final int arg1, int arg2) {
                final int var1 = 0;
                int var2 = 0;

                field = 10;

                Calcultable calc = new Calcultable() {

                        //args2, var2: Not final. Value can't be modified.
                        
                        @Override
                        public int sum() {

                                //args1, var1: Final. Value can't be modified.

                                int result = field + arg1 + arg2 + var1 + var2;
                                return result;
                        }
                };

                System.out.println(calc.sum());
        }
}