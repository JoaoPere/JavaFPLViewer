package serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;


public class FPLBootstrapStatic {
    @SerializedName(value="total_players")
    private int totalPlayers;
    private FPLEvent[] events;
    @JsonAdapter(value=FPLTeamAdapter.class)
    private HashMap<Integer, FPLTeam> teams;
    private FPLElement[] elements;

    public class FPLElement {
        @SerializedName(value="first_name")
        private String firstName;

        @SerializedName(value="second_name")
        private String lastName;

        @SerializedName(value="points_per_game")
        private float pointsPerGame;

        private int minutes;

        @SerializedName(value="goals_scored")
        private int goalsScored;

        private int assists;

        @SerializedName(value="total_points")
        private int totalPoints;

        @SerializedName(value="team_code")
        private int teamCode;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public float getPointsPerGame() {
            return pointsPerGame;
        }

        public void setPointsPerGame(float pointsPerGame) {
            this.pointsPerGame = pointsPerGame;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getGoalsScored() {
            return goalsScored;
        }

        public void setGoalsScored(int goalsScored) {
            this.goalsScored = goalsScored;
        }

        public int getAssists() {
            return assists;
        }

        public void setAssists(int assists) {
            this.assists = assists;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public int getTeamCode() {
            return teamCode;
        }

        public void setTeamCode(int teamCode) {
            this.teamCode = teamCode;
        }
    }

    public class FPLTeamAdapter extends TypeAdapter<HashMap<Integer, FPLTeam>> {
        @Override
        public void write(JsonWriter out, HashMap<Integer, FPLTeam> value) throws IOException {

        }

        @Override
        public HashMap<Integer, FPLTeam> read(JsonReader in) throws IOException {
            HashMap<Integer, FPLTeam> teams = new HashMap<Integer, FPLTeam>();
            in.beginArray();

            int key = -1;
            String teamName = "";
            String teamShortName = "";

            while (in.hasNext()) {
                in.beginObject();
                while(in.hasNext()) {
                    String name = in.nextName();
                    if (name.equals("code")) {
                        key = in.nextInt();
                    }
                    else if (name.equals("name")) {
                        teamName = in.nextString();
                    }
                    else if (name.equals("short_name")) {
                        teamShortName = in.nextString();
                    }
                    else {
                        in.skipValue();
                    }
                }
                FPLTeam team = new FPLTeam(teamName, teamShortName);
                teams.put(key, team);
                in.endObject();
            }
            in.endArray();
            return teams;
        }

    }

    public class FPLTeam{
        FPLTeam(String name, String shortName) {
            this.name = name;
            this.shortName = shortName;
        }

        private String name;
        private String shortName;

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class FPLEvent {
        public class FPLChipPlay {
            @SerializedName(value="chip_name")
            private String chipName;

            @SerializedName(value="num_played")
            private int numPlayed;


            public String getChipName() {
                return chipName;
            }

            public void setChipName(String chipName) {
                this.chipName = chipName;
            }

            public int getNumPlayed() {
                return numPlayed;
            }

            public void setNumPlayed(int numPlayed) {
                this.numPlayed = numPlayed;
            }
        }

        public class FPLTopElementInfo {
            private int id;
            private int points;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }
        }
        private String name;

        @SerializedName(value="deadline_time")
        private String deadlineTime;

        @SerializedName(value="average_entry_score")
        private int averageEntryScore;

        private boolean finished;

        @SerializedName(value="data_checked")
        private boolean dataChecked;

        @SerializedName(value="highest_scoring_entry")
        private int highestScoringEntry;

        @SerializedName(value="deadline_time_epoch")
        private int deadlineTimeEpoch;

        @SerializedName(value="deadline_time_game_offset")
        private int deadlineTimeGameOffset;

        @SerializedName(value="highest_score")
        private int highestScore;

        @SerializedName(value="is_previous")
        private boolean isPrevious;

        @SerializedName(value="is_current")
        private boolean isCurrent;

        @SerializedName(value="is_next")
        private boolean isNext;

        @SerializedName(value="chip_plays")
        private FPLChipPlay[] chipPlays;

        @SerializedName(value="most_selected")
        private int mostSelected;

        @SerializedName(value="most_transferred_in")
        private int mostTransferredIn;

        @SerializedName(value="top_element_info")
        private FPLTopElementInfo topElementInfo;

        @SerializedName(value="transfers_made")
        private int transfersMade;

        @SerializedName(value="most_captained")
        private int mostCaptained;

        @SerializedName(value="most_vice_captained")
        private int mostViceCaptained;


        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public int getAverageEntryScore() {
            return averageEntryScore;
        }

        public String getDeadlineTime() {
            return deadlineTime;
        }

        public void setDeadlineTime(String deadlineTime) {
            this.deadlineTime = deadlineTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAverageEntryScore(int averageEntryScore) {
            this.averageEntryScore = averageEntryScore;
        }

        public boolean isDataChecked() {
            return dataChecked;
        }

        public void setDataChecked(boolean dataChecked) {
            this.dataChecked = dataChecked;
        }

        public int getHighestScoringEntry() {
            return highestScoringEntry;
        }

        public void setHighestScoringEntry(int highestScoringEntry) {
            this.highestScoringEntry = highestScoringEntry;
        }

        public int getDeadlineTimeEpoch() {
            return deadlineTimeEpoch;
        }

        public void setDeadlineTimeEpoch(int deadlineTimeEpoch) {
            this.deadlineTimeEpoch = deadlineTimeEpoch;
        }

        public int getDeadlineTimeGameOffset() {
            return deadlineTimeGameOffset;
        }

        public void setDeadlineTimeGameOffset(int deadlineTimeGameOffset) {
            this.deadlineTimeGameOffset = deadlineTimeGameOffset;
        }

        public int getHighestScore() {
            return highestScore;
        }

        public void setHighestScore(int highestScore) {
            this.highestScore = highestScore;
        }

        public boolean isPrevious() {
            return isPrevious;
        }

        public void setPrevious(boolean previous) {
            isPrevious = previous;
        }

        public boolean isCurrent() {
            return isCurrent;
        }

        public void setCurrent(boolean current) {
            isCurrent = current;
        }

        public boolean isNext() {
            return isNext;
        }

        public void setNext(boolean next) {
            isNext = next;
        }

        public FPLChipPlay[] getChipPlays() {
            return chipPlays;
        }

        public void setChipPlays(FPLChipPlay[] chipPlays) {
            this.chipPlays = chipPlays;
        }

        public int getMostSelected() {
            return mostSelected;
        }

        public void setMostSelected(int mostSelected) {
            this.mostSelected = mostSelected;
        }

        public int getMostTransferredIn() {
            return mostTransferredIn;
        }

        public void setMostTransferredIn(int mostTransferredIn) {
            this.mostTransferredIn = mostTransferredIn;
        }

        public FPLTopElementInfo getTopElementInfo() {
            return topElementInfo;
        }

        public void setTopElementInfo(FPLTopElementInfo topElementInfo) {
            this.topElementInfo = topElementInfo;
        }

        public int getTransfersMade() {
            return transfersMade;
        }

        public void setTransfersMade(int transfersMade) {
            this.transfersMade = transfersMade;
        }

        public int getMostCaptained() {
            return mostCaptained;
        }

        public void setMostCaptained(int mostCaptained) {
            this.mostCaptained = mostCaptained;
        }

        public int getMostViceCaptained() {
            return mostViceCaptained;
        }

        public void setMostViceCaptained(int mostViceCaptained) {
            this.mostViceCaptained = mostViceCaptained;
        }
    }

    public HashMap<Integer, FPLTeam> getTeams() {
        return teams;
    }

    public void setTeams(HashMap<Integer, FPLTeam>teams) {
        this.teams = teams;
    }

    public FPLEvent[] getEvents() {
        return events;
    }
    public void setEvents(FPLEvent[] events) {
        this.events = events;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public FPLElement[] getElements() {
        return elements;
    }

    public void setElements(FPLElement[] elements) {
        this.elements = elements;
    }
}