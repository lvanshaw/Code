import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';  // Assuming you have an auth service
import { AppRoutingModule } from './app-routing.module';
import { tree } from 'd3';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.authService.isLoggedIn.subscribe(loggedIn => {
    });
  }


  isLoggedIn() {
    return this.authService.isLoggedIn;
  }

 logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}


/*
import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import * as d3 from "d3";
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { LoginComponent } from './login/login.component';

interface HierarchyDatum {
  name: string;
  value: number;
  children?: Array<HierarchyDatum>;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [HttpClientModule, LoginComponent]
})
export class AppComponent implements OnInit {
  title = 'd3tree';
  @ViewChild('chart', { static: true }) private chartContainer!: ElementRef;

  root: any;
  tree: any;
  svg: any;

  treeData: any;
  nodes: any[] = [];
  links: any;

  height: number = 640;
  width: number = 500;
  margin: any = { top: 200, bottom: 90, left: 100, right: 90 };
  duration: number = 750;
  nodeWidth: number = 5;
  nodeHeight: number = 5;
  nodeRadius: number = 5;
  horizontalSeparationBetweenNodes: number = 5;
  verticalSeparationBetweenNodes: number = 5;

  token: string = ''; // Variable to store the token
  _host_url : string = 'https://5000-idx-backend-1739288102446.cluster-a3grjzek65cxex762e4mwrzl46.cloudworkstations.dev/';
  constructor(private http: HttpClient) {
    this.click = this.click.bind(this);
  }

  ngOnInit() {
    this.authenticateUser();
  }

  authenticateUser() {
    // Check if the token exists in localStorage
    const storedToken = localStorage.getItem('auth_token');
    if (storedToken) {
      console.log('Token found in localStorage:', storedToken);
      this.token = storedToken;
      // Step 3: Fetch the user data using the token
      this.fetchDataAndRenderTree('User');
    } else {
      // If no token in localStorage, send POST request to get the token
      const credentials = {
        email: 'testuser@example.com',
        password: 'password123'
      };
      
      this.http.post<any>(`${this._host_url}api/auth/login`, credentials)
        .pipe(
          map(response => {
            console.log('Full response:', response); // Log the entire response
            return response.access_token; // Extract the token from the response
          }),
          catchError(err => {
            console.error('Error during authentication', err);
            throw err;
          })
        )
        .subscribe(token => {
          // Step 2: Store the token in localStorage
          this.token = token;
          localStorage.setItem('auth_token', token); // Store token in localStorage
          console.log("Token saved to localStorage: ", token);
          // Step 3: Fetch the user data using the token
          this.fetchDataAndRenderTree('User');
        });
    }
  }
  
  authenticateUser_() {
      // If no token in localStorage, send POST request to get the token
      const credentials = {
        email: 'testuser@example.com',
        password: 'password123'
      };
      
      this.http.post<any>(`${this._host_url}api/auth/login`, credentials)
        .pipe(
          map(response => {
            console.log('Full response:', response); // Log the entire response
            return response.access_token; // Extract the token from the response
          }),
          catchError(err => {
            console.error('Error during authentication', err);
            throw err;
          })
        )
        .subscribe(token => {
          // Step 2: Store the token in localStorage
          this.token = token;
          localStorage.setItem('auth_token', token); // Store token in localStorage
          console.log("Token saved to localStorage: ", token);
          // Step 3: Fetch the user data using the token
          this.fetchDataAndRenderTree('User');
        });
    
  }
  
  
  fetchDataAndRenderTree(modelName: string) {
    this.http.get<any[]>(`${this._host_url}api/models/${modelName}`, {
      headers: {
        'Authorization': `Bearer ${this.token}`
      }
    }).subscribe(data => {
      // Transform the flat data into a hierarchical format
      const hierarchicalData = this.transformToHierarchy(data);
      // Render the tree chart
      this.renderTreeChart(hierarchicalData);
    });
  }
  
  transformToHierarchy(data: any[]): HierarchyDatum {
    const root: HierarchyDatum = { name: 'Root', value: 0, children: [] };
  
    // Process each item in the dataset
    data.forEach((item) => {
      const transformedItem = this.processItem(item);
      root.children!.push(transformedItem); // Add the transformed item as a child of the root
    });
  
    return root; // Return the hierarchical data structure
  }
  
  processItem(item: any): HierarchyDatum {
    const node: HierarchyDatum = {
      name: `${item.name || 'Unnamed'}`, // Use the name if available, else 'Unnamed'
      value: 1,
      children: [] // Initialize children as an empty array
    };
  
    // Loop through each property of the item to check if it's a simple value or a list/object
    Object.keys(item).forEach(key => {
      const value = item[key];
  
      if (Array.isArray(value)) {
        // If the property is an array, create a new child node for each item in the array
        const arrayNode: HierarchyDatum = {
          name: `${key}:`, // Use the key as the node name (e.g., 'addresses:')
          value: 1,
          children: value.map((arrayItem: any) => this.createChildNode(arrayItem)) // Process each item in the array
        };
        node.children!.push(arrayNode);
      } else if (typeof value === 'object' && value !== null) {
        // If the property is an object, create a new node and recursively process its properties
        const objectNode: HierarchyDatum = {
          name: `${key}:`,  // Use the key as the node name (e.g., 'address:')
          value: 1,
          children: this.processItem(value).children // Recursively process the object
        };
        node.children!.push(objectNode);
      } else {
        // Otherwise, simply create a node for the value (string, number, etc.)
        const valueNode: HierarchyDatum = {
          name: `${key}: ${value}`, // Show the key and value (e.g., 'email: user@example.com')
          value: 1,
          children: [] // No children for simple key-value pairs
        };
        node.children!.push(valueNode);
      }
    });
  
    return node; // Return the processed node
  }
  
  // Helper function to create child nodes for array items
  createChildNode(value: any): HierarchyDatum {
    return {
      name: `${value}`,  // Convert array item to a string (adjust if necessary)
      value: 1,
      children: [] // No further children for simple array items
    };
  }
  
  

  renderTreeChart(data: HierarchyDatum) {
    let element: any = this.chartContainer.nativeElement;
    this.width = element.offsetWidth - this.margin.left - this.margin.right;
    this.height = element.offsetHeight - this.margin.top - this.margin.bottom;

    this.svg = d3.select(element).append('svg')
      .attr('width', element.offsetWidth)
      .attr('height', element.offsetHeight)
      .append("g")
      .attr('transform', 'translate(' + this.margin.left + ',' + this.margin.top + ')');

    this.tree = d3.tree()
      .size([this.height, this.width])
      .nodeSize([this.nodeWidth + this.horizontalSeparationBetweenNodes, this.nodeHeight + this.verticalSeparationBetweenNodes])
      .separation((a, b) => { return a.parent == b.parent ? 5 : 10 });

    this.root = d3.hierarchy(data, (d: any) => { return d.children; });
    this.root.x0 = this.height / 2;
    this.root.y0 = 10;

    this.updateChart(this.root);
  }

  click(event: MouseEvent, d: any) {
    if (d.children) {
      d._children = d.children;
      d.children = null;
    } else {
      d.children = d._children;
      d._children = null;
    }

    this.updateChart(d);
  }

  updateChart(source: any) {
    let i = 0;
    this.treeData = this.tree(this.root);
    this.nodes = this.treeData.descendants();
    this.links = this.treeData.descendants().slice(1);
    this.nodes.forEach((d: any) => { d.y = d.depth * 180 });

    let node = this.svg.selectAll('g.node')
      .data(this.nodes, (d: any) => { return d.id || (d.id = ++i); });

    let nodeEnter = node.enter().append('g')
      .attr('class', 'node')
      .attr('transform', (d: any) => {
        return 'translate(' + source.y0 + ',' + source.x0 + ')';
      })
      .on('click', (event: MouseEvent, d: any) => this.click(event, d));

    nodeEnter.append('circle')
      .attr('class', 'node')
      .attr('r', 1e-6)
      .style('fill', (d: any) => { return d._children ? 'lightsteelblue' : '#fff'; });

    nodeEnter.append('text')
      .attr('dy', '.35em')
      .attr('x', (d: any) => {
        return d.children || d._children ? -13 : 13;
      })
      .attr('text-anchor', (d: any) => {
        return d.children || d._children ? 'end' : 'start';
      })
      .style('font', '12px sans-serif')
      .text((d: any) => { return d.data.name; });

    let nodeUpdate = nodeEnter.merge(node);

    nodeUpdate.transition()
      .duration(this.duration)
      .attr('transform', (d: any) => { return 'translate(' + d.y + ',' + d.x + ')'; });

    nodeUpdate.select('circle.node')
      .attr('r', 10)
      .style('stroke-width', '3px')
      .style('stroke', 'steelblue')
      .style('fill', (d: any) => { return d._children ? 'lightsteelblue' : '#fff'; })
      .attr('cursor', 'pointer');

    let nodeExit = node.exit().transition()
      .duration(this.duration)
      .attr('transform', (d: any) => { return 'translate(' + source.y + ',' + source.x + ')'; })
      .remove();

    nodeExit.select('circle')
      .attr('r', 1e-6);

    nodeExit.select('text')
      .style('fill-opacity', 1e-6);

    let link = this.svg.selectAll('path.link')
      .data(this.links, (d: any) => { return d.id; });

    let linkEnter = link.enter().insert('path', 'g')
      .attr('class', 'link')
      .style('fill', 'none')
      .style('stroke', '#ccc')
      .style('stroke-width', '2px')
      .attr('d', function (d: any) {
        let o = { x: source.x0, y: source.y0 };
        return diagonal(o, o);
      });

    let linkUpdate = linkEnter.merge(link);

    linkUpdate.transition()
      .duration(this.duration)
      .attr('d', (d: any) => { return diagonal(d, d.parent); });

    let linkExit = link.exit().transition()
      .duration(this.duration)
      .attr('d', function (d: any) {
        let o = { x: source.x, y: source.y };
        return diagonal(o, o);
      })
      .remove();

    this.nodes.forEach((d: any) => {
      d.x0 = d.x;
      d.y0 = d.y;
    });

    function diagonal(s: any, d: any) {
      let path = `M ${s.y} ${s.x}
                  C ${(s.y + d.y) / 2} ${s.x},
                  ${(s.y + d.y) / 2} ${d.x},
                  ${d.y} ${d.x}`;
      return path;
    }
  }
} 
*/
