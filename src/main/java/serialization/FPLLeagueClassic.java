package serialization;

import com.google.gson.annotations.SerializedName;

public class FPLLeagueClassic {
    private FPLLeague league;
    

    public FPLLeague getLeague() {
        return league;
    }

    public void setLeague(FPLLeague league) {
        this.league = league;
    }

    public class FPLLeague {
        private int id;
        private String name;
        private boolean closed;
        @SerializedName(value="max_entries")
        private int maxEntries;
        @SerializedName(value="league_type")
        private String leagueType;
        private int scoring;
        @SerializedName(value="admin_entry")
        private int adminEntry;
        @SerializedName(value="start_event")
        private int startEvent;
        @SerializedName(value="code_privacy")
        private String codePrivacy;
        private int rank;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }

        public int getMaxEntries() {
            return maxEntries;
        }

        public void setMaxEntries(int maxEntries) {
            this.maxEntries = maxEntries;
        }

        public String getLeagueType() {
            return leagueType;
        }

        public void setLeagueType(String leagueType) {
            this.leagueType = leagueType;
        }

        public int getScoring() {
            return scoring;
        }

        public void setScoring(int scoring) {
            this.scoring = scoring;
        }

        public int getAdminEntry() {
            return adminEntry;
        }

        public void setAdminEntry(int adminEntry) {
            this.adminEntry = adminEntry;
        }

        public int getStartEvent() {
            return startEvent;
        }

        public void setStartEvent(int startEvent) {
            this.startEvent = startEvent;
        }

        public String getCodePrivacy() {
            return codePrivacy;
        }

        public void setCodePrivacy(String codePrivacy) {
            this.codePrivacy = codePrivacy;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public class FPLStandings {
        private int page;
        private FPLResult[] results;
        
        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public FPLResult[] getResults() {
            return results;
        }

        public void setResults(FPLResult[] results) {
            this.results = results;
        }

        public class FPLResult {
            private int id;
            @SerializedName(value="event_total")
            private int eventTotal;
            @SerializedName(value="player_name")
            private String playerName;
            private int rank;
            @SerializedName(value="last_rank")
            private int lastRank;
            @SerializedName(value="rank_sort")
            private int rankSort;
            private int total;
            private int entry;
            @SerializedName(value="entry_name")
            private String entryName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getEventTotal() {
                return eventTotal;
            }

            public void setEventTotal(int eventTotal) {
                this.eventTotal = eventTotal;
            }

            public String getPlayerName() {
                return playerName;
            }

            public void setPlayerName(String playerName) {
                this.playerName = playerName;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getLastRank() {
                return lastRank;
            }

            public void setLastRank(int lastRank) {
                this.lastRank = lastRank;
            }

            public int getRankSort() {
                return rankSort;
            }

            public void setRankSort(int rankSort) {
                this.rankSort = rankSort;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getEntry() {
                return entry;
            }

            public void setEntry(int entry) {
                this.entry = entry;
            }

            public String getEntryName() {
                return entryName;
            }

            public void setEntryName(String entryName) {
                this.entryName = entryName;
            }
        }
    }
}
