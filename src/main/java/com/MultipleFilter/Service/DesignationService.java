package com.MultipleFilter.Service;

import java.util.List;

import com.MultipleFilter.Dto.DesignationDto;

public interface DesignationService {

	public List<DesignationDto> getAllDesignation();

	public String addDesignation(DesignationDto designationDto);

	public String deleteDesignation(Long id);

	public String updateDesignation(DesignationDto designationDto, Long id);

}
