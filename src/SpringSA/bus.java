package SpringSA;

public class bus {

    int busNum;
    int oil = 100;
    int maxPassenger = 30;
    int passenger;
    int charge = 1000;
    int speed = 0;
    int state;


    bus () {
        runBus();

        int min = 10;
        int max = 100;
        int random = (int) ((Math.random() * (max - min)) + min);
        System.out.println("버스 번호 : " + random);
    }

    void runBus() {
        state = 1;
        this.passenger = 0;
        System.out.println("상태 = 운행중");
    }

    void oilAmount(int oil) {
        this.oil += oil;
        System.out.println("주유량 = " + (this.oil));

        if (this.oil< 10) {
            System.out.println("주유가 필요합니다.");
            garage();
        }
    }

    void garage() {
        state = 2;
        System.out.println("상태 = 차고지행");
    }

    void onBoard(int passenger) {
        if (state == 1) {
            this.passenger += passenger;
            if (this.passenger <= maxPassenger ) {
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (maxPassenger - this.passenger));
                System.out.println("요금 확인 = " + (passenger * charge));
            } else if (this.passenger > maxPassenger) {
                System.out.println("최대 승객 수 초과");
                this.passenger -= passenger;
            }
        }
    }

    void speedChange(int speed) {
        if (this.oil >= 10) {
            this.speed += speed;
            System.out.println("현재 속도 = " + this.speed);
        } else {
            System.out.println("주유량을 확인해 주세요.");
        }
    }
}
