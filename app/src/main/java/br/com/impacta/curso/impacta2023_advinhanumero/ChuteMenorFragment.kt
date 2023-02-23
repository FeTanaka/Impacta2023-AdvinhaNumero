package br.com.impacta.curso.impacta2023_advinhanumero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.impacta.curso.impacta2023_advinhanumero.databinding.FragmentChuteMenorBinding


class ChuteMenorFragment : Fragment() {

    private var _binding: FragmentChuteMenorBinding? = null
    private val binding get() = _binding!!
    private val args: ChuteMenorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChuteMenorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("IMPACTA", "numeroSorteado: ${args.numeroSorteado}")
        binding.button3.setOnClickListener {
            val acao = ChuteMenorFragmentDirections.actionChuteMenorFragmentToInicialFragment(args.numeroSorteado)
            findNavController().navigate(acao)
        }
    }


}