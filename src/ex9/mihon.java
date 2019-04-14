package ex9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class mihon {

    /** 駅クラス */
    static class Station implements Comparable<Station> {
        String name;
        List<Route> routes = new ArrayList<Route>();
        /** 始点からのコスト */
        int cost = Integer.MAX_VALUE;

        public Station(String name) {
            this.name = name;
        }

        public void addRoute(Station to, int dist) {
            routes.add(new Route(this, to, dist));
        }

        @Override
        public String toString() {
            return name;
        }

        public int compareTo(Station o) {
            return cost - o.cost;
        }
    }

    /** 経路クラス */
    static class Route {
        Station from;
        Station to;
        /** 経路間コスト */
        int cost;

        public Route(Station from, Station to, int dist) {
            this.from = from;
            this.to = to;
            this.cost = dist;
        }
    }

    public static void main(String[] args) {
        Station[] stations = { new Station("横浜"), new Station("武蔵小杉"),
                new Station("品川"), new Station("渋谷"), new Station("新橋"),
                new Station("溜池山王"), };

        stations[0].addRoute(stations[1], 12);
        stations[0].addRoute(stations[2], 28);
        stations[1].addRoute(stations[2], 10);
        stations[1].addRoute(stations[3], 13);
        stations[2].addRoute(stations[3], 11);
        stations[2].addRoute(stations[4], 7);
        stations[3].addRoute(stations[5], 9);
        stations[4].addRoute(stations[5], 4);

        // 始点
        stations[0].cost = 0;

        // PQに挿入
        PriorityQueue<Station> pq = new PriorityQueue<Station>(
                Arrays.asList(stations));
        while (!pq.isEmpty()) {
            Station s = pq.poll();
            for (Route route : s.routes) {
                Station to = route.to;
                int cost = s.cost + route.cost;
                if (cost < to.cost) {
                    pq.remove(to);
                    // コストを更新して入れ替え
                    to.cost = cost;
                    pq.add(to);
                }
            }
        }

        for (Station s : stations) {
            System.out.println(stations[0] + " → " + s + " " + s.cost + "分");
        }
    }

}