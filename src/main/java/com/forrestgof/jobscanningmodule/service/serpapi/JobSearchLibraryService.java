package com.forrestgof.jobscanningmodule.service.serpapi;

import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.google.gson.JsonObject;

public interface JobSearchLibraryService {
	public JsonObject search(SearchFilter searchFilter);
}
