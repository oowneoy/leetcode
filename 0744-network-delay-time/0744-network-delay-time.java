class Solution {
    static class Network implements Comparable<Network> {
        int distance;
        int to;

        Network(int distance, int to) {
            this.distance = distance;
            this.to = to;
        }

        @Override
        public int compareTo(Network o) {
            return Integer.compare(distance, o.distance);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Network>> networkMap = new HashMap<>();
        for (int[] time : times) {
            networkMap.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new Network(time[2], time[1]));
        }

        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(k, 0);

        PriorityQueue<Network> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Network(0, k));

        while (!priorityQueue.isEmpty()) {
            Network currentNetwork = priorityQueue.poll();
            int from = currentNetwork.to;
            if (networkMap.get(from) == null) {
                continue;
            }
            for (Network network : networkMap.get(from)) {
                int distance = network.distance;
                int to = network.to;

                if (distanceMap.get(from) + distance < distanceMap.get(to)) {
                    priorityQueue.offer(new Network(distanceMap.get(from) + distance, to));
                    distanceMap.put(to, distanceMap.get(from) + distance);
                }

            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distanceMap.get(i) == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, distanceMap.get(i));
        }

        return answer;
    }
}