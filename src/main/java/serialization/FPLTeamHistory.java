package serialization;

import com.google.gson.annotations.SerializedName;

public class FPLTeamHistory {
    private FPLChip[] chips;
    private FPLPast[] past;
    private FPLCurrent[] current;

    public FPLChip[] getChips() {
        return chips;
    }

    public void setChips(FPLChip[] chips) {
        this.chips = chips;
    }

    public FPLPast[] getPast() {
        return past;
    }

    public void setPast(FPLPast[] past) {
        this.past = past;
    }

    public FPLCurrent[] getCurrent() {
        return current;
    }

    public void setCurrent(FPLCurrent[] current) {
        this.current = current;
    }

    public class FPLChip {
        private String name;
        private int event;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEvent() {
            return event;
        }

        public void setEvent(int event) {
            this.event = event;
        }
//        private Date time;
    }

    public class FPLPast {
        @SerializedName(value="season_name")
        private String seasonName;

        @SerializedName(value="total_points")
        private int totalPoints;

        private int rank;

        public String getSeasonName() {
            return seasonName;
        }

        public void setSeasonName(String seasonName) {
            this.seasonName = seasonName;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public class FPLCurrent {
        private int event;
        private int points;

        @SerializedName(value="total_points")
        private int totalPoints;

        private int rank;

        @SerializedName(value="rank_sort")
        private int rankSort;

        @SerializedName(value="overall_rank")
        private int overallRank;

        private int bank;
        private int value;

        @SerializedName(value="event_transfers")
        private int eventTransfers;

        @SerializedName(value="event_transfers_cost")
        private int eventTransfersCost;

        @SerializedName(value="points_on_bench")
        private int pointsOnBench;

        public int getEvent() {
            return event;
        }

        public void setEvent(int event) {
            this.event = event;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRankSort() {
            return rankSort;
        }

        public void setRankSort(int rankSort) {
            this.rankSort = rankSort;
        }

        public int getOverallRank() {
            return overallRank;
        }

        public void setOverallRank(int overallRank) {
            this.overallRank = overallRank;
        }

        public int getBank() {
            return bank;
        }

        public void setBank(int bank) {
            this.bank = bank;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getEventTransfers() {
            return eventTransfers;
        }

        public void setEventTransfers(int eventTransfers) {
            this.eventTransfers = eventTransfers;
        }

        public int getEventTransfersCost() {
            return eventTransfersCost;
        }

        public void setEventTransfersCost(int eventTransfersCost) {
            this.eventTransfersCost = eventTransfersCost;
        }

        public int getPointsOnBench() {
            return pointsOnBench;
        }

        public void setPointsOnBench(int pointsOnBench) {
            this.pointsOnBench = pointsOnBench;
        }
    }
}
