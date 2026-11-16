package serie04;

public class Cloture {
    public static void main(String[] args) {
        // 1 = land, 0 = water. Each border segment is 2.5 m long.
        int[][] carte = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        boolean validValues = true;
        boolean validBorders = true;
        int value;
        int borderAmount = 0;
        boolean isLakeLeft = false;
        boolean isLakeRight = false;
        boolean lakeDownRight = false;
        boolean lakeDownLeft = false;
        boolean lakeUpRight = false;
        boolean lakeUpLeft = false; 
        
        for (int i = 0; i < carte.length; i++){
            for (int j =0; j < carte[i].length; j++){
                isLakeLeft = false;
                isLakeRight = false;
                lakeDownRight = false;
                lakeDownLeft = false;
                lakeUpRight = false;
                lakeUpLeft = false;
                value = carte[i][j];
                if (!(value == 0 || value==1)){
                    System.out.print("Votre carte du terrain n'a pas le bon format :\nvaleur '" + value);
                    System.out.print("' trouvée en position [" + i);
                    System.out.print("][" + j);
                    System.out.println("]");
                    return;
                }

                if (value == 1){
                    if (j == 0 || carte[i][j-1] == 0){
                        for (int n = 0; n < j; n++){
                            if (carte[i][n]==1){
                                isLakeLeft = true;
                            }
                        }
                        if (!isLakeLeft){
                            borderAmount +=1;
                        }
                    }
                    if (j == carte[i].length-1 || carte[i][j+1] == 0){
                        for (int n = j + 1; n < carte[i].length; n++){
                            if (carte[i][n]==1){
                                isLakeRight = true;
                            }
                        }
                        if (!isLakeRight){
                            borderAmount += 1;
                        }
                    }
                    if (i == 0){
                        borderAmount += 1;
                    }else if (carte[i-1][j] == 0){
                        for (int n = j+1; n < carte[i-1].length; n++){ // is there land on both sides of the cell above?
                            if (carte[i-1][n]==1){
                                lakeUpRight = true;
                            }
                        }
                        for (int n = 0; n < j; n++){
                            if (carte[i-1][n]==1){
                                lakeUpLeft = true;
                            }
                        }
                        if (!(lakeUpLeft && lakeUpRight)){
                            borderAmount += 1;
                        }
                    }
                    if (i == carte.length - 1){
                        borderAmount += 1;
                    }else if (carte[i+1][j] ==0){
                        for (int n = j+1; n < carte[i+1].length; n++){ // is there land on both sides of the cell below?
                            if (carte[i+1][n]==1){
                                lakeDownRight = true;
                            }
                        }
                        for (int n = 0; n < j; n++){
                            if (carte[i+1][n]==1){
                                lakeDownLeft = true;
                            }
                        }
                        if (!(lakeDownLeft && lakeDownRight)){
                            borderAmount += 1;
                        } 

                        }

                }else{
                    boolean borderRight = false;
                    boolean borderLeft = false;
                    if (j > 0 && j < carte[i].length -1){
                        for (int n = j+1; n < carte[i].length; n++){ // is there land on both sides of the cell below?
                            if (carte[i][n]==1){
                                borderRight = true;
                            }
                        }
                        for (int n = 0; n < j; n++){
                            if (carte[i][n]==1){
                                borderLeft = true;
                            }
                        }
                        if (borderLeft && borderRight ){
                            if (i == 0 || i == carte.length - 1){
                                System.out.println("Votre carte du terrain n'a pas le bon format :");
                                System.out.print("bord extérieur entrant trouvé en position [" + (i+1));
                                System.out.print("][" + j);
                                System.out.println("]");
                                return;
                            }
                            boolean lakeDownDownLeft = false;
                            boolean lakeDownDownRight = false;
                            if (carte[i+1][j] ==0){
                                for (int n = j; n < carte[i+1].length; n++){
                                    if (carte[i+1][n]==1){
                                        lakeDownDownRight = true;
                                    }
                                }
                                for (int n = 0; n < j; n++){
                                    if (carte[i+1][n]==1){
                                        lakeDownDownLeft = true;
                                    }
                                }
                                if (!(lakeDownDownLeft && lakeDownDownRight)){
                                    System.out.println("Votre carte du terrain n'a pas le bon format :");
                                    System.out.print("bord extérieur entrant trouvé en position [" + (i+1));
                                    System.out.print("][" + j);
                                    System.out.println("]");
                                    return;
                                }
                            }
                            boolean lakeUpUpLeft = false;
                            boolean lakeUpUpRight = false;
                            if (carte[i-1][j] ==0){
                                for (int n = j; n < carte[i-1].length; n++){
                                    if (carte[i-1][n]==1){
                                        lakeUpUpRight = true;
                                    }
                                }
                                for (int n = 0; n < j; n++){
                                    if (carte[i-1][n]==1){
                                        lakeUpUpLeft = true;
                                    }
                                }
                                if (!(lakeUpUpLeft && lakeUpUpRight)){
                                    System.out.println("Votre carte du terrain n'a pas le bon format :");
                                    System.out.print("bord extérieur entrant trouvé en position [" + (i+1));
                                    System.out.print("][" + j);
                                    System.out.println("]");
                                    return;
                                }
                            }     
                        }
                    }
                }
            }
        }

        double borderLen = 2.5 * borderAmount;
        System.out.print("Il vous faut " + borderLen);
        System.out.println(" mètres de clôture pour votre terrain.");
    }
}