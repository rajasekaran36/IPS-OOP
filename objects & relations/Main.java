interface WriteAble{
    public void display();
    public void write(String word);
}
// A Pen
class Pen implements WriteAble{
    String color;
    int inkLevel;
    Pen(){
        this.color = "Blue";
        this.inkLevel = 100;
    }
     @Override
    public void display(){
        System.out.println("Color:"+this.color);
        System.out.println("inkLevel:"+this.inkLevel);
    }

    //Writes
    @Override
    public void write(String word){
        System.out.println(word);
        this.inkLevel -= word.length();
    }
}

// A Pencil
class Pencil implements WriteAble {
    String color;
    int length;
    int sharpness;
    Pencil(){
        this.color = "Black";
        this.length = 100;
        this.sharpness = 0;
    }
    public void write(String word){
       {
            for(int i=0;i<word.length();i++){
                if(this.sharpness>30){
                    System.out.println(word.charAt(i));
                    this.sharpness -= 5;
                }
                else{
                    System.out.println("Sharpness below 30");
                    Sharpner.sharp(this);
                }
            }

        }
    }
    public void display(){
        System.out.println("Color:"+this.color);
        System.out.println("length:"+this.length);
        System.out.println("Sharpness:"+this.sharpness);
    }
}

//A Sharpner
class Sharpner{
    static int bladeSharpness = 100;
    static void sharp(Pencil pencil){
        if(bladeSharpness>30){
            if(pencil.length>10){
                pencil.sharpness = 100;
                pencil.length -= 10;
            }
            else{
                System.out.println("You sharpit anymore");
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        
        WriteAble writeAble = new Pen();
        writeAble.display();
        writeAble.write("hello");
        writeAble.display();

        writeAble = new Pencil();
        writeAble.display();
        Sharpner sharpner = new Sharpner();
        writeAble.write("hello");
        writeAble.display();
    }
}