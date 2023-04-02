class JustCreate{

    public static void create(int n) {
        int created = 0;
        for (int i = 0; i < n; i++){
            Object dummy = new Object();
            dummy = null;
            created += 1;
            if (i != 0 && i%1000 == 0){
                System.out.println("Object created: "+ created);
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 1)
            JustCreate.create(Integer.parseInt(args[0]));
    }

}