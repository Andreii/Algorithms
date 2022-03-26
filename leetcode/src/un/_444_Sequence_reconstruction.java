package un;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _444_Sequence_reconstruction {
    public static void main(String[] args) {
        _444_Sequence_reconstruction c = new _444_Sequence_reconstruction();
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(new ArrayList<>() {{ add(1); add(2); }});
        seqs.add(new ArrayList<>() {{ add(2); add(3); }});
        seqs.add(new ArrayList<>() {{ add(1); add(3); }});
        System.out.println(c.sequenceReconstruction(new int[]{1,2,3}, seqs));
    }

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int[] indegree = new int[nums.length+1];

        Arrays.fill(indegree, 0);
        // nums = 1,2,3
        // sequences = [[1,2],[1,3],[2,3]]
        // indegree = [0,0,0,0]
        LinkedList<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> seq : sequences) {
            if (seq.size() == 1) continue;

            for(int i = 1; i < seq.size(); i++) {
                indegree[seq.get(i)]++;
                adj.get(seq.get(i-1)).add(seq.get(i));
            }
        }

        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            if(q.size() > 1) return false;
            Integer node = q.pop();
            topo.add(node);
            for(Integer u : adj.get(node)) {
                indegree[u] --;
                if(indegree[u] == 0) q.add(u);
            }
        }

        return Arrays.stream(nums).boxed().collect(Collectors.toList()).equals(topo);
    }
}
