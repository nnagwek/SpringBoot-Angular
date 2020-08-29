import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, searchTerm: any ): unknown {
    if (value.length ===0){
      return value
    }
    return value.filter(function(search){
      return search.description.toLowerCase().indexOf(searchTerm.toLowerCase()) > -1
    })
  }

}

// ...args: unknown[]