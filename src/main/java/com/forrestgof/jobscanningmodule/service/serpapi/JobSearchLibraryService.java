package com.forrestgof.jobscanningmodule.service.serpapi;

import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.google.gson.JsonObject;

interface JobSearchLibraryService {

	JsonObject search(SearchFilter searchFilter);
}
