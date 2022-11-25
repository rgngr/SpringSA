package SpringSA;

public class taxi {

    int taxiNum;
    int oil;
    int speed = 0;
    int passenger;
    int maxPassenger = 4;
    int basicDistance = 1;
    int distance;
    int basicCharge = 3000;
    int chargePer = 1000;
    int charge;
    int total = 0;
    int state;

    taxi () {
        nomal();
        this.oil = 100;
        System.out.println("주유량 = " + this.oil);

        int min = 10;
        int max = 100;
        int random = (int) ((Math.random() * (max - min)) + min);
        System.out.println("택시 번호 : " + random);
    }

    void nomal() {
            state = 1;
            System.out.println("상태 = 일반");
    }

    void runTaxi() {
        state = 2;
        System.out.println("상태 = 운행중");
    }

    void stopTaxi() {
        state = 3;
        System.out.println("상태 = 운행 불가");
        System.out.println("주유 필요");
    }

    void oilAmount(int oil) {
        this.oil += oil;
        System.out.println("주유량 = " + (this.oil));

        if (this.oil == 0) {
            stopTaxi();
        }
    }

    void onBoard(int passenger, String destination, int distance) {
        if (state == 1) {
            this.passenger += passenger;
            this.distance = distance;
            if (this.passenger <= maxPassenger ) {
                System.out.println("탑승 승객 수 = " + this.passenger);
                System.out.println("잔여 승객 수 = " + (maxPassenger - this.passenger));
                System.out.println("기본 요금 확인 = " + basicCharge);
                System.out.println("목적지 = " + destination);
                System.out.println("목적지까리 거리 = " + this.distance + "km");
                System.out.println("지불할 요금 = " + charge());
                runTaxi();
            } else if (this.passenger > maxPassenger) {
                System.out.println("최대 승객 수 초과");
                this.passenger -= passenger;
            }
        }
    }

    int charge() {
        if (this.distance > 1) {
            this.charge = basicCharge + chargePer * (this.distance - basicDistance);
            return this.charge;
        }
        return basicCharge;
    }

    void pay() {
        if (state == 3) {
            passenger = 0;
            this.total += charge();
            System.out.println("누적 요금 = " + total);
        }else {
            state = 1;
            passenger = 0;
            this.total += charge();
            System.out.println("누적 요금 = " + total);
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
