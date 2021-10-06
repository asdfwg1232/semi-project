public List<PlayerDto_batter> playerFindByYears() throws ClassNotFoundException, SQLException {
		String sql = "select * from batter order by avg desc limit 10";
		
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst = conn.prepareStatement(sql)){		
			try(ResultSet rs = pst.executeQuery()){
				
				List<PlayerDto_batter> plaList = new ArrayList<PlayerDto_batter>();
				while(rs.next()) {
					plaList.add(new PlayerDto_batter(
							rs.getInt("number"),
							rs.getString("name"),
							rs.getInt("salary"),
							rs.getInt("deposit"),
							rs.getString("position"),
							rs.getDouble("avg"),
							rs.getInt("hr"),
							rs.getInt("sb")));
				}
				return plaList;
			}
		}
	}
