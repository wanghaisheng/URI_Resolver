package edu.mayo.cts2.uriresolver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class UriResultsMapper implements RowMapper<UriResults>{
	@Override
	public UriResults mapRow(ResultSet rs, int rowNum) throws SQLException{
		UriResults uriData = new UriResults();
		
		uriData.setResourceType(rs.getString("resourceType"));
		uriData.setResourceName(rs.getString("resourceName"));
		uriData.setResourceURI(rs.getString("resourceURI"));
		uriData.setBaseEntityURI(rs.getString("baseEntityURI"));
		uriData.setVersionOf(rs.getString("VersionOf"));
		
		String identifier = rs.getString("identifier");
		if(identifier != null){
			List<String> identifiers = new ArrayList<String>();
			identifiers.add(identifier);
			while(rs.next()){
				identifiers.add(rs.getString("identifier"));			
			}
			uriData.setIdentifiers(identifiers );
		}
		

		return uriData;
	}

}