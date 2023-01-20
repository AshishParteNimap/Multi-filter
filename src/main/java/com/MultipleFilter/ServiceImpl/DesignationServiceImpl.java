package com.MultipleFilter.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultipleFilter.Dto.DesignationDto;
import com.MultipleFilter.Entity.Designation;
import com.MultipleFilter.Repository.DesignationRepository;
import com.MultipleFilter.Service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public List<DesignationDto> getAllDesignation() {
		List<Designation> designations = designationRepository.findAll();
		List<DesignationDto> designationDtos = designations.stream().map(dg -> new DesignationDto(dg.getDesignation()))
				.collect(Collectors.toList());
		return designationDtos;
	}

	@Override
	public String addDesignation(DesignationDto designationDto) {
		Designation designations = new Designation();
		designations.ListDesignation(designationDto.getDesignation());
		designationRepository.save(designations);
		return "designation added";
	}

	@Override
	public String deleteDesignation(Long id) {
		Designation designation = designationRepository.findById(id).orElse(null);
		designationRepository.delete(designation);
		return "designation deleted";
	}

	@Override
	public String updateDesignation(DesignationDto designationDto, Long id) {
		Designation designations = designationRepository.findById(id).orElse(null);
		designations.ListDesignation(designationDto.getDesignation());
		designationRepository.save(designations);
		return "designation updated";
	}

}
